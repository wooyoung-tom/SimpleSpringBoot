package wooyoung.tom.simplespringboot.restaurant

import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.favorite.MarketFavoriteRepository
import wooyoung.tom.simplespringboot.restaurant.dto.PagedRestaurantItem
import wooyoung.tom.simplespringboot.utils.PagedMetaData
import wooyoung.tom.simplespringboot.restaurant.dto.PagedRestaurantResponse
import wooyoung.tom.simplespringboot.review.MarketReviewRepository
import wooyoung.tom.simplespringboot.utils.getDistance

@Service
open class MarketRestaurantService(
    private val marketRestaurantRepository: MarketRestaurantRepository,
    private val marketReviewRepository: MarketReviewRepository,
    private val marketFavoriteRepository: MarketFavoriteRepository
) {

    // 음식점 탐색 pagination
    @Transactional
    open fun findCategorizedRestaurants(
        category: String, latitude: String, longitude: String, pageable: Pageable
    ): PagedRestaurantResponse {
        // 페이징 결과물
        val pagingResult = marketRestaurantRepository
            .findMarketRestaurantEntitiesByCategory(category, pageable)

        val metaData = PagedMetaData(
            end = pagingResult.isLast,
            totalResults = pagingResult.totalElements,
            totalPages = pagingResult.totalPages,
            page = pagingResult.number,
            size = pagingResult.size
        )

        val mappedContents = pagingResult.content.map {
            val distance = getDistance(
                lat1 = latitude.toDouble(),
                lng1 = longitude.toDouble(),
                lat2 = it.latitude.toDouble(),
                lng2 = it.longitude.toDouble()
            )

            val reviewCount = marketReviewRepository.findAllByRestaurantId(it.id).size
            val favoriteCount = marketFavoriteRepository.findAllByRestaurantId(it.id).size

            PagedRestaurantItem(
                restaurantId = it.id,
                restaurantName = it.name,
                category = it.category,
                roadAddress = it.roadAddress,
                jibunAddress = it.jibunAddress,
                phoneNumber = it.phoneNumber,
                longitude = it.longitude,
                latitude = it.latitude,
                menuList = it.menuList,
                distance = distance,
                reviewCount = reviewCount,
                favoriteCount = favoriteCount
            )
        }

        return PagedRestaurantResponse(
            meta = metaData,
            body = mappedContents
        )
    }
}
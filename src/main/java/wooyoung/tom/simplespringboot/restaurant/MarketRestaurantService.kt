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

    // 즐겨찾기 해놓은 음식점 찾기
    open fun findFavoriteRestaurants(
        userId: Long, category: String, lat: String, lng: String, pageable: Pageable
    ): PagedRestaurantResponse {
        val favoriteRestaurants = marketFavoriteRepository
            .findAllByUserIdAndStatus(userId, pageable = pageable)

        val metaData = PagedMetaData(
            end = favoriteRestaurants.isLast,
            totalResults = favoriteRestaurants.totalElements,
            totalPages = favoriteRestaurants.totalPages,
            page = favoriteRestaurants.number,
            size = favoriteRestaurants.size
        )

        val convertedList = favoriteRestaurants.content.filter {
            // 카테고리 동일한 음식점 파싱
            it.restaurant.category == category
        }.map {
            val distance = getDistance(
                lat1 = lat.toDouble(),
                lat2 = it.restaurant.latitude.toDouble(),
                lng1 = lng.toDouble(),
                lng2 = it.restaurant.longitude.toDouble()
            )

            val reviewCount = marketReviewRepository
                .findAllByRestaurantId(it.restaurant.id).size
            val favoriteCount = marketFavoriteRepository
                .findAllByRestaurantId(it.restaurant.id).size

            PagedRestaurantItem(
                restaurantId = it.restaurant.id,
                restaurantName = it.restaurant.name,
                category = it.restaurant.category,
                roadAddress = it.restaurant.roadAddress,
                jibunAddress = it.restaurant.jibunAddress,
                phoneNumber = it.restaurant.phoneNumber,
                longitude = it.restaurant.longitude,
                latitude = it.restaurant.latitude,
                distance = distance,
                reviewCount = reviewCount,
                favoriteCount = favoriteCount,
                menuList = it.restaurant.menuList
            )
        }

        return PagedRestaurantResponse(
            meta = metaData,
            body = convertedList
        )
    }
}
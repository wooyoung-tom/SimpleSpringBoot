package wooyoung.tom.simplespringboot.restaurant

import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import wooyoung.tom.simplespringboot.restaurant.dto.PagedRestaurantItem
import wooyoung.tom.simplespringboot.utils.PagedMetaData
import wooyoung.tom.simplespringboot.restaurant.dto.PagedRestaurantResponse

@Service
open class MarketRestaurantService(
    private val marketRestaurantRepository: MarketRestaurantRepository
) {

    // 음식점 탐색 with pagination
    open fun findCategorizedRestaurants(
        category: String, pageable: Pageable
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
            PagedRestaurantItem(
                restaurantId = it.id,
                restaurantName = it.name,
                category = it.category,
                roadAddress = it.roadAddress,
                jibunAddress = it.jibunAddress,
                phoneNumber = it.phoneNumber,
                longitude = it.longitude,
                latitude = it.latitude,
                menuList = it.menuList
            )
        }

        return PagedRestaurantResponse(
            meta = metaData,
            body = mappedContents
        )
    }
}
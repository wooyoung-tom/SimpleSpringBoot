package wooyoung.tom.simplespringboot.market.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.market.dto.restaurant.CategorizedRestaurantItem
import wooyoung.tom.simplespringboot.market.dto.restaurant.MarketRestaurantCategorized
import wooyoung.tom.simplespringboot.market.repository.MarketRestaurantRepository
import wooyoung.tom.simplespringboot.utils.getDistance

@Service
open class MarketRestaurantService(
    private val marketRestaurantRepository: MarketRestaurantRepository
) {

    /**
     * 음식점 아이템에 항상 메뉴 Join 해서 붙인 후 반환
     */
    @Transactional
    open fun findRestaurantsByCategory(
        lat: String,
        lng: String,
        category: String
    ): MarketRestaurantCategorized {

        // category 로 구분한 음식점 가져온다.
        // TODO Paging 구현할 시간이 있으면 구현, Filtering 구현
        val categorizedRestaurantList = marketRestaurantRepository
            .findMarketRestaurantsByCategory(category)

        // distance, review, favorite 개수를 가지고 있는 아이템으로 mapping
        val convertedList = categorizedRestaurantList.map { marketRestaurant ->
            val distanceCalResult = getDistance(
                lat1 = marketRestaurant.latitude.toDouble(),
                lat2 = lat.toDouble(),
                lng1 = marketRestaurant.longitude.toDouble(),
                lng2 = lng.toDouble()
            )

            CategorizedRestaurantItem(
                restaurant = marketRestaurant,
                distance = distanceCalResult,
                review = marketRestaurant.reviewList.size,
                favorite = marketRestaurant.favoriteList.size
            )
        }

        return MarketRestaurantCategorized(
            category = category,
            body = convertedList
        )
    }
}
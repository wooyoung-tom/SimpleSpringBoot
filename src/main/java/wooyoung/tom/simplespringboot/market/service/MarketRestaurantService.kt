package wooyoung.tom.simplespringboot.market.service

import org.springframework.stereotype.Service
import wooyoung.tom.simplespringboot.market.dto.restaurant.CategorizedRestaurantItem
import wooyoung.tom.simplespringboot.market.dto.restaurant.MarketRestaurantCategorized
import wooyoung.tom.simplespringboot.market.repository.MarketRestaurantRepository
import wooyoung.tom.simplespringboot.utils.getDistance

@Service
open class MarketRestaurantService(
    private val marketRestaurantRepository: MarketRestaurantRepository
) {

    open fun findRestaurantsByCategory(
        lat: String,
        lng: String,
        category: String,
        favorite: Boolean,
        distance: Boolean,
        review: Boolean,
        literal: Boolean
    ): MarketRestaurantCategorized {

        val categorizedRestaurantList = marketRestaurantRepository
            .findMarketRestaurantsByCategory(category)

        val convertedList = categorizedRestaurantList.map { marketRestaurant ->
            val distanceCalResult = getDistance(
                lat1 = marketRestaurant.latitude.toDouble(),
                lat2 = lat.toDouble(),
                lng1 = marketRestaurant.longitude.toDouble(),
                lng2 = lng.toDouble()
            )
            CategorizedRestaurantItem(marketRestaurant, distanceCalResult)
        }

        return MarketRestaurantCategorized(
            category = category,
            body = convertedList
        )
    }
}
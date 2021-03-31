package wooyoung.tom.simplespringboot.market.service

import org.springframework.stereotype.Service
import wooyoung.tom.simplespringboot.market.dto.MarketRestaurantCategorized
import wooyoung.tom.simplespringboot.market.repository.MarketRestaurantsRepository

@Service
open class MarketRestaurantsService(
    private val marketRestaurantsRepository: MarketRestaurantsRepository
) {

    open fun findRestaurantsByCategory(category: String): MarketRestaurantCategorized {
        return MarketRestaurantCategorized(
            category = category,
            body = marketRestaurantsRepository.findMarketRestaurantsByCategory(category)
        )
    }
}
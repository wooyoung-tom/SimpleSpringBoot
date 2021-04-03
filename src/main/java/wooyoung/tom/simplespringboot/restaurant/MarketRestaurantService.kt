package wooyoung.tom.simplespringboot.restaurant

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
open class MarketRestaurantService(
    private val marketRestaurantRepository: MarketRestaurantRepository
) {

    open fun findCategorizedRestaurants(
        category: String, pageable: Pageable
    ): Page<MarketRestaurantEntity> {
        return marketRestaurantRepository
            .findMarketRestaurantEntitiesByCategory(category, pageable)
    }
}
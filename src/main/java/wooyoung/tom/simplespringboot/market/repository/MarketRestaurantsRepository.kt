package wooyoung.tom.simplespringboot.market.repository

import org.springframework.data.jpa.repository.JpaRepository
import wooyoung.tom.simplespringboot.market.entity.MarketRestaurants

interface MarketRestaurantsRepository: JpaRepository<MarketRestaurants, Long> {

    fun findMarketRestaurantsByCategory(category: String): List<MarketRestaurants>
}
package wooyoung.tom.simplespringboot.market.repository

import org.springframework.data.jpa.repository.JpaRepository
import wooyoung.tom.simplespringboot.market.entity.MarketRestaurant

interface MarketRestaurantRepository: JpaRepository<MarketRestaurant, Long> {

    fun findMarketRestaurantsByCategory(category: String): List<MarketRestaurant>

}
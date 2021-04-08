package wooyoung.tom.simplespringboot.restaurant

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import wooyoung.tom.simplespringboot.restaurant.data.MarketRestaurantEntity

interface MarketRestaurantRepository : JpaRepository<MarketRestaurantEntity, Long> {

    // simple pagination test
    fun findMarketRestaurantEntitiesByCategory(
        category: String, pageable: Pageable
    ): Page<MarketRestaurantEntity>
}
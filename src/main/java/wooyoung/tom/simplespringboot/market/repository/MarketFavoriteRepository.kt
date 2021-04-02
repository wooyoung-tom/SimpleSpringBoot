package wooyoung.tom.simplespringboot.market.repository

import org.springframework.data.jpa.repository.JpaRepository
import wooyoung.tom.simplespringboot.market.entity.MarketFavorite
import wooyoung.tom.simplespringboot.market.entity.MarketRestaurant

interface MarketFavoriteRepository : JpaRepository<MarketFavorite, Long> {

    fun findMarketFavoritesByUserId(userId: Long): List<MarketFavorite>

    fun findMarketFavoriteByUserIdAndFavoriteMarketRestaurant(
        userId: Long, restaurant: MarketRestaurant
    ): MarketFavorite?
}
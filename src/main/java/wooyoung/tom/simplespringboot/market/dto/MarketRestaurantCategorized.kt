package wooyoung.tom.simplespringboot.market.dto

import wooyoung.tom.simplespringboot.market.entity.MarketRestaurants

data class MarketRestaurantCategorized(
    val category: String,
    val body: List<MarketRestaurants>
)

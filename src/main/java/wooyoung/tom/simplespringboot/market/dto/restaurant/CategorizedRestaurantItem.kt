package wooyoung.tom.simplespringboot.market.dto.restaurant

import wooyoung.tom.simplespringboot.market.entity.MarketRestaurant

data class CategorizedRestaurantItem(
    val restaurant: MarketRestaurant,
    val distance: Int,
    val review: Int = 0,
    val favorite: Int = 0
)
package wooyoung.tom.simplespringboot.market.dto.order

import wooyoung.tom.simplespringboot.market.entity.MarketOrderDetail

data class BasketItem(
    val restaurantName: String,
    val menuList: List<MarketOrderDetail>,
    val totalPrice: Int
)

package wooyoung.tom.simplespringboot.order.dto

import wooyoung.tom.simplespringboot.order.detail.MarketOrderDetailEntity
import wooyoung.tom.simplespringboot.restaurant.data.MarketRestaurantEntity

data class MarketOrderIncludingDetails(
    val orderId: Long,
    val restaurant: MarketRestaurantEntity,
    val totalPrice: Int,
    val orderDetailList: List<MarketOrderDetailEntity>
)
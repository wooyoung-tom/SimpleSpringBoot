package wooyoung.tom.simplespringboot.order.dto

import wooyoung.tom.simplespringboot.order.detail.MarketOrderDetailEntity

data class MarketOrderFindResponseItem(

    val orderId: Long,

    val restaurantName: String,

    val totalPrice: Int,

    val orderDetailList: List<MarketOrderDetailEntity>
)

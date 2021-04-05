package wooyoung.tom.simplespringboot.order.dto

data class MarketOrderFindResponse(
    val code: String,
    val message: String,
    val orders: List<MarketOrderFindResponseItem> = ArrayList()
)
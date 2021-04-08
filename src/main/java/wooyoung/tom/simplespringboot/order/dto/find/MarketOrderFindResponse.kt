package wooyoung.tom.simplespringboot.order.dto.find

data class MarketOrderFindResponse(
    val code: String,
    val message: String,
    val orders: List<MarketOrderFindResponseItem> = ArrayList()
)
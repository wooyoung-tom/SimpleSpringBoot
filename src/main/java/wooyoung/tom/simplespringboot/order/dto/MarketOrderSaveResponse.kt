package wooyoung.tom.simplespringboot.order.dto

data class MarketOrderSaveResponse(
    val code: String,
    val message: String,
    val order: MarketOrderFindResponseItem? = null
)

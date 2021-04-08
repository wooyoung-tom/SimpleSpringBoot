package wooyoung.tom.simplespringboot.order.dto.save

import wooyoung.tom.simplespringboot.order.dto.find.MarketOrderFindResponseItem

data class MarketOrderSaveResponse(
    val code: String,
    val message: String,
    val order: MarketOrderFindResponseItem? = null
)

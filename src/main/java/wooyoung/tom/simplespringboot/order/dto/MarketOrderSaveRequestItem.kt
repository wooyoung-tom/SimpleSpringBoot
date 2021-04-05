package wooyoung.tom.simplespringboot.order.dto

data class MarketOrderSaveRequestItem(
    val menuId: Long,
    val menuCount: Int
)
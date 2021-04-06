package wooyoung.tom.simplespringboot.order.dto

data class MarketOrderDetailEditRequest(
    val orderId: Long,
    val menuList: List<MarketOrderSaveRequestItem>
)

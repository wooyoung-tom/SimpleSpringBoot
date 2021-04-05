package wooyoung.tom.simplespringboot.order.dto

data class MarketOrderSaveRequest(
    val userId: Long,
    val restaurantId: Long,
    val menuList: List<MarketOrderSaveRequestItem>
)

package wooyoung.tom.simplespringboot.order.dto.save

data class MarketOrderSaveRequest(
    val userId: Long,
    val restaurantId: Long,
    val menuList: List<MarketOrderSaveRequestItem>
)
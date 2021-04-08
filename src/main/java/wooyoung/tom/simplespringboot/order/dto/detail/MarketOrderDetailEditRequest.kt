package wooyoung.tom.simplespringboot.order.dto.detail

import wooyoung.tom.simplespringboot.order.dto.save.MarketOrderSaveRequestItem

data class MarketOrderDetailEditRequest(
    val orderId: Long,
    val menuList: List<MarketOrderSaveRequestItem>
)

package wooyoung.tom.simplespringboot.payment.dto.later

import wooyoung.tom.simplespringboot.order.dto.find.MarketOrderFindResponseItem
import java.time.LocalDateTime

data class MarketPaymentLaterItem(
    val id: Long,
    val method: String,
    val status: String,
    val datetime: LocalDateTime,
    val orderItems: List<MarketOrderFindResponseItem>
)
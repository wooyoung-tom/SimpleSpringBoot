package wooyoung.tom.simplespringboot.payment.dto

import wooyoung.tom.simplespringboot.order.dto.MarketOrderIncludingDetails
import java.time.LocalDateTime

data class MarketPaymentLaterItem(
    val id: Long,
    val method: String,
    val status: String,
    val datetime: LocalDateTime,
    val orderItems: List<MarketOrderIncludingDetails>
)
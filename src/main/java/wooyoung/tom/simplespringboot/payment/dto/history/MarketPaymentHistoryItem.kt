package wooyoung.tom.simplespringboot.payment.dto.history

import java.time.LocalDateTime

data class MarketPaymentHistoryItem(
    val id: Long,
    val method: String,
    val date: LocalDateTime,
    val orders: List<MarketPaymentHistoryOrderItem>,
    val price: Int
)

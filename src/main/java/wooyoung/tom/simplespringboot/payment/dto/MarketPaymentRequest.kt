package wooyoung.tom.simplespringboot.payment.dto

data class MarketPaymentRequest(
    val orders: List<Long>,
    val method: String
)
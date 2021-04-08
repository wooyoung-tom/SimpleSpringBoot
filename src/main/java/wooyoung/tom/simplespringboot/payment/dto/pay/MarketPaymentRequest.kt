package wooyoung.tom.simplespringboot.payment.dto.pay

data class MarketPaymentRequest(
    val orders: List<Long>,
    val method: String
)
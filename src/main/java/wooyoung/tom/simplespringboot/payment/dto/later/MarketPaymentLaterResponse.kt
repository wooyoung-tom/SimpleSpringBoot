package wooyoung.tom.simplespringboot.payment.dto.later

data class MarketPaymentLaterResponse(
    val code: String,
    val message: String,
    val paymentList: List<MarketPaymentLaterItem>
)

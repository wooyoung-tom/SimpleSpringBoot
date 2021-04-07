package wooyoung.tom.simplespringboot.payment.dto

data class MarketPaymentLaterResponse(
    val code: String,
    val message: String,
    val paymentList: List<MarketPaymentLaterItem>
)

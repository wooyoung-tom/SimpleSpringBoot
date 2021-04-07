package wooyoung.tom.simplespringboot.payment.dto

import wooyoung.tom.simplespringboot.payment.MarketPaymentEntity

data class MarketPaymentLaterResponse(
    val code: String,
    val message: String,
    val paymentList: List<MarketPaymentEntity>
)

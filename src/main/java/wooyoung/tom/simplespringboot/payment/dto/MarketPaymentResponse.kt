package wooyoung.tom.simplespringboot.payment.dto

import wooyoung.tom.simplespringboot.payment.MarketPaymentEntity

data class MarketPaymentResponse(
    val code: String,
    val message: String,
    val payment: MarketPaymentEntity? = null
)

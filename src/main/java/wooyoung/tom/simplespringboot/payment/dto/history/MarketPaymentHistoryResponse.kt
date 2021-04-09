package wooyoung.tom.simplespringboot.payment.dto.history

data class MarketPaymentHistoryResponse(
    val code: String,
    val message: String,
    val histories: List<MarketPaymentHistoryItem> = ArrayList()
)
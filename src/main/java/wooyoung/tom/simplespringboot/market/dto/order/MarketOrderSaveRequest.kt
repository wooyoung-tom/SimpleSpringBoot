package wooyoung.tom.simplespringboot.market.dto.order

data class MarketOrderSaveRequest(
    val items: List<MarketOrderSaveItem>
)
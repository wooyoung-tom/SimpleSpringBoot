package wooyoung.tom.simplespringboot.market.dto.favorite

data class MarketFavoriteRequest(
    val userId: Long,
    val restaurantId: Long
)
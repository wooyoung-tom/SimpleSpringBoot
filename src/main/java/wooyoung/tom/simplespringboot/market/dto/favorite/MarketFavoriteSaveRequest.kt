package wooyoung.tom.simplespringboot.market.dto.favorite

data class MarketFavoriteSaveRequest(
    val userId: Long,
    val restaurantId: Long
)
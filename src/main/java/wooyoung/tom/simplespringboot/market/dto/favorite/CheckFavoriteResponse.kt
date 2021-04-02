package wooyoung.tom.simplespringboot.market.dto.favorite

data class CheckFavoriteResponse(
    val favoriteId: Long? = null,
    val checkFavorite: Boolean
)

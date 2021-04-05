package wooyoung.tom.simplespringboot.favorite.dto

data class CheckFavoriteRequest(
    val userId: Long,
    val restaurantId: Long
)

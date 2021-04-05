package wooyoung.tom.simplespringboot.favorite.dto

data class FavoriteRequest(
    val userId: Long,
    val restaurantId: Long
)

package wooyoung.tom.simplespringboot.favorite.dto

data class FavoriteControlRequest(
    val userId: Long,
    val restaurantId: Long
)

package wooyoung.tom.simplespringboot.favorite.dto

data class FavoriteRegisterRequest(
    val userId: Long,
    val restaurantId: Long
)

package wooyoung.tom.simplespringboot.favorite.dto

data class FavoriteCheckResponse(
    val code: String,
    val message: String,
    val favorite: Boolean = false
)

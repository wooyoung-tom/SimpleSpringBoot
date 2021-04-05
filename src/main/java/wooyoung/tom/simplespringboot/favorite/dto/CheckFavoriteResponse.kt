package wooyoung.tom.simplespringboot.favorite.dto

data class CheckFavoriteResponse(
    val code: String,
    val message: String,
    val favorite: Boolean = false
)

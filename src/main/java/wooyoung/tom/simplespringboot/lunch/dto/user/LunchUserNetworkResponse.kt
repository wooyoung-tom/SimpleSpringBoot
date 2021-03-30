package wooyoung.tom.simplespringboot.lunch.dto.user

data class LunchUserNetworkResponse<out T>(
    val code: String,
    val message: String,
    val body: T?
)
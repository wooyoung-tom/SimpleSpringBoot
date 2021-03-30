package wooyoung.tom.simplespringboot.lunch.dto.history

data class LunchHistoryNetworkResponse<out T>(
    val code: String,
    val message: String,
    val body: T?
)
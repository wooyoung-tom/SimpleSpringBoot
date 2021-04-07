package wooyoung.tom.simplespringboot.user.dto

data class MarketUserSignInRequest(
    val userId: String,
    val password: String,
)
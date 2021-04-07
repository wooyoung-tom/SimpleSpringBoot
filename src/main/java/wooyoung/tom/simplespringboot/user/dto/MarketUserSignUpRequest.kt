package wooyoung.tom.simplespringboot.user.dto

data class MarketUserSignUpRequest(
    val userId: String,
    val password: String,
    val username: String
)

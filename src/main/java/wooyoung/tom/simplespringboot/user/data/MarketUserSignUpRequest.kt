package wooyoung.tom.simplespringboot.user.data

data class MarketUserSignUpRequest(
    val userId: String,
    val password: String,
    val username: String
)

package wooyoung.tom.simplespringboot.user.data

data class MarketUserSignInRequest(
    val userId: String,
    val password: String,
)
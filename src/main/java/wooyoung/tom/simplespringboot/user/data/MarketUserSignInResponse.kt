package wooyoung.tom.simplespringboot.user.data

data class MarketUserSignInResponse(
    val code: String,
    val message: String,
    val user: MarketUserEntity? = null
)

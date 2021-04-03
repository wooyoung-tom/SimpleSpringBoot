package wooyoung.tom.simplespringboot.user.dto

data class MarketUserSignInResponse(
    val code: String,
    val message: String,
    val user: MarketUserSigningDTO? = null
)

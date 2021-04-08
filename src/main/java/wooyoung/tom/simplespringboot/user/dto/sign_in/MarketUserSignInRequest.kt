package wooyoung.tom.simplespringboot.user.dto.sign_in

data class MarketUserSignInRequest(
    val userId: String,
    val password: String,
)
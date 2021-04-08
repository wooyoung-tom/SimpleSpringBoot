package wooyoung.tom.simplespringboot.user.dto.sign_up

data class MarketUserSignUpRequest(
    val userId: String,
    val password: String,
    val username: String
)

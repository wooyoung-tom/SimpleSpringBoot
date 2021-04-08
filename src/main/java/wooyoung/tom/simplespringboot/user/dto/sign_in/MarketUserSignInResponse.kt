package wooyoung.tom.simplespringboot.user.dto.sign_in

import wooyoung.tom.simplespringboot.user.MarketUserEntity

data class MarketUserSignInResponse(
    val code: String,
    val message: String,
    val user: MarketUserEntity? = null
)
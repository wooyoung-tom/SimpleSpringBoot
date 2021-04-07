package wooyoung.tom.simplespringboot.user.dto

import wooyoung.tom.simplespringboot.user.MarketUserEntity

data class MarketUserSignInResponse(
    val code: String,
    val message: String,
    val user: MarketUserEntity? = null
)

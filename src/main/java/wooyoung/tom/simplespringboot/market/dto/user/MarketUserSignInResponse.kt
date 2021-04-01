package wooyoung.tom.simplespringboot.market.dto.user

import wooyoung.tom.simplespringboot.market.entity.MarketUser

data class MarketUserSignInResponse(
    val code: String,
    val body: MarketUser?
)
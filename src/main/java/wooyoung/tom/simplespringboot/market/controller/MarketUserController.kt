package wooyoung.tom.simplespringboot.market.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import wooyoung.tom.simplespringboot.market.dto.user.MarketUserSignInRequest
import wooyoung.tom.simplespringboot.market.dto.user.MarketUserSignInResponse
import wooyoung.tom.simplespringboot.market.dto.user.MarketUserSignUpRequest
import wooyoung.tom.simplespringboot.market.dto.user.MarketUserSignUpResponse
import wooyoung.tom.simplespringboot.market.service.MarketUserService

@RestController
open class MarketUserController(
    private val marketUserService: MarketUserService
) {

    @PostMapping("/market/users/signup")
    open fun signUp(
        @RequestBody user: MarketUserSignUpRequest
    ): MarketUserSignUpResponse {
        return marketUserService.signUp(user)
    }

    @PostMapping("/market/users/signin")
    open fun simpleSignIn(
        @RequestBody user: MarketUserSignInRequest
    ): MarketUserSignInResponse {
        return marketUserService.simpleSignIn(user)
    }
}
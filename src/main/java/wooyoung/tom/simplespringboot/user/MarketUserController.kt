package wooyoung.tom.simplespringboot.user

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import wooyoung.tom.simplespringboot.user.dto.MarketUserSigningRequest
import wooyoung.tom.simplespringboot.user.dto.MarketUserSignUpResponse

@RestController
open class MarketUserController(
    private val marketUserService: MarketUserService
) {

    // 회원가입
    @PostMapping("/users/register")
    fun signUp(
        @RequestBody user: MarketUserSigningRequest
    ): MarketUserSignUpResponse {
        return marketUserService.signUp(user)
    }

    // 로그인
    @PostMapping("/users/sign-in")
    fun signIn(
        @RequestBody user: MarketUserSigningRequest
    ) {

    }
}
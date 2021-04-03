package wooyoung.tom.simplespringboot.user

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import wooyoung.tom.simplespringboot.user.dto.MarketUserSignInResponse
import wooyoung.tom.simplespringboot.user.dto.MarketUserSigningRequest
import wooyoung.tom.simplespringboot.user.dto.MarketUserSignUpResponse

@RestController
@RequestMapping("/users")
open class MarketUserController(
    private val marketUserService: MarketUserService
) {

    // 회원가입
    @PostMapping("/register")
    fun signUp(
        @RequestBody user: MarketUserSigningRequest
    ): MarketUserSignUpResponse {
        return marketUserService.signUp(user)
    }

    // 로그인
    @PostMapping("/sign-in")
    fun signIn(
        @RequestBody user: MarketUserSigningRequest
    ): MarketUserSignInResponse {
        return marketUserService.signIn(user)
    }
}
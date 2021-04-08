package wooyoung.tom.simplespringboot.user

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import wooyoung.tom.simplespringboot.utils.CommonSimpleResponse
import wooyoung.tom.simplespringboot.user.dto.sign_in.MarketUserSignInRequest
import wooyoung.tom.simplespringboot.user.dto.sign_in.MarketUserSignInResponse
import wooyoung.tom.simplespringboot.user.dto.sign_up.MarketUserSignUpRequest

@RestController
@RequestMapping("/users")
open class MarketUserController(
    private val marketUserService: MarketUserService
) {

    // 회원가입
    @PostMapping("/register")
    fun signUp(
        @RequestBody user: MarketUserSignUpRequest
    ): CommonSimpleResponse {
        return marketUserService.signUp(user)
    }

    // 로그인
    @PostMapping("/sign-in")
    fun signIn(
        @RequestBody user: MarketUserSignInRequest
    ): MarketUserSignInResponse {
        return marketUserService.signIn(user)
    }
}
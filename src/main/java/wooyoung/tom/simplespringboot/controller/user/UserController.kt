package wooyoung.tom.simplespringboot.controller.user

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import wooyoung.tom.simplespringboot.domain.User
import wooyoung.tom.simplespringboot.service.UserService

@RestController
open class UserController(
    private val userService: UserService
) {

    // 회원가입 및 로그인
    @PostMapping("/users/signing")
    open fun signingUser(user: User): User {
        return userService.signingUser(user)
    }
}
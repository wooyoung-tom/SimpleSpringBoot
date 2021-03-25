package wooyoung.tom.simplespringboot.lunch.controller

import org.springframework.web.bind.annotation.*
import wooyoung.tom.simplespringboot.lunch.dto.user.LunchUserRequest
import wooyoung.tom.simplespringboot.lunch.dto.user.LunchUserResponse
import wooyoung.tom.simplespringboot.lunch.repository.user.LunchUser
import wooyoung.tom.simplespringboot.lunch.service.LunchUserService

@RestController
open class LunchUserController(
    private val lunchUserService: LunchUserService
) {

    // 로그인
    @GetMapping("/lunch/users/{name}")
    open fun signIn(@PathVariable name: String): LunchUserResponse {
        return lunchUserService.signInUser(name)
    }

    @PostMapping("/lunch/users")
    open fun signUp(@RequestBody user: LunchUserRequest): LunchUserResponse {
        val userEntity = LunchUser(user.name, user.teamName)
        return lunchUserService.signUpUser(userEntity)
    }
}
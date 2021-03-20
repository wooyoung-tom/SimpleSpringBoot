package wooyoung.tom.simplespringboot.controller.lunch

import org.springframework.web.bind.annotation.*
import wooyoung.tom.simplespringboot.dto.lunch.user.LunchUserResponse
import wooyoung.tom.simplespringboot.repository.lunch.user.LunchUser
import wooyoung.tom.simplespringboot.service.lunch.LunchUserService

@RestController
open class LunchUserController(
    private val lunchUserService: LunchUserService
) {

    @GetMapping("/lunch/users/{name}")
    open fun signIn(@PathVariable name: String): LunchUserResponse {
        return lunchUserService.signInUser(name)
    }

    @PostMapping("/lunch/users")
    open fun signUp(@RequestBody user: LunchUser): LunchUserResponse {
        return lunchUserService.signUpUser(user)
    }
}
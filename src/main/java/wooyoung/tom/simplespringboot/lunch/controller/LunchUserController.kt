package wooyoung.tom.simplespringboot.lunch.controller

import org.springframework.web.bind.annotation.*
import wooyoung.tom.simplespringboot.lunch.dto.user.LunchUserRequest
import wooyoung.tom.simplespringboot.lunch.dto.user.LunchUserResponse
import wooyoung.tom.simplespringboot.lunch.service.LunchUserService

@RestController
open class LunchUserController(
    private val lunchUserService: LunchUserService
) {

    @GetMapping("/lunch/users/{id}")
    open fun signIn(@PathVariable id: String): LunchUserResponse {
        return lunchUserService.signIn(id)
    }

    @PostMapping("/lunch/users")
    open fun signUp(@RequestBody user: LunchUserRequest): LunchUserResponse {
        return lunchUserService.signUp(user)
    }
}
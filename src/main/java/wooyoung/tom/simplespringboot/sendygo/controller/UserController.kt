package wooyoung.tom.simplespringboot.sendygo.controller

import org.springframework.web.bind.annotation.*
import wooyoung.tom.simplespringboot.sendygo.repository.user.User
import wooyoung.tom.simplespringboot.sendygo.dto.UserCreditRequest
import wooyoung.tom.simplespringboot.sendygo.service.UserService

@RestController
open class UserController(
    private val userService: UserService
) {

    // 회원가입 및 로그인
    @PostMapping("/users/signing")
    open fun signingUser(@RequestBody user: User): User {
        return userService.signingUser(user)
    }

    // 랭킹 조회
    @GetMapping("/users/ranking")
    open fun getUserRankingList(): List<User> {
        return userService.getUserRankingList()
    }

    // 크레딧 업데이트 POST ver.
    @PostMapping("/users/update/credit")
    open fun updateUserCredit(@RequestBody userCreditInfo: UserCreditRequest): Int {
        return userService.updateUserCredit(userCreditInfo.id, userCreditInfo.credit)
    }

    // 크레딧 업데이트 PATCH ver.
    @PatchMapping("/users/{id}/credit")
    open fun patchUserCredit(@PathVariable id: String, @RequestBody credit: Long): Int {
        return userService.updateUserCredit(id, credit)
    }
}
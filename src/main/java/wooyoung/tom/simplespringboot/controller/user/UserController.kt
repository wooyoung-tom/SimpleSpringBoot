package wooyoung.tom.simplespringboot.controller.user

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import wooyoung.tom.simplespringboot.domain.User
import wooyoung.tom.simplespringboot.dto.UserCreditUpdateDTO
import wooyoung.tom.simplespringboot.service.UserService

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

    // 크레딧 업데이트
    @PostMapping("/users/update/credit")
    open fun updateUserCredit(@RequestBody userCreditInfo: UserCreditUpdateDTO): Int {
        return userService.updateUserCredit(userCreditInfo.id, userCreditInfo.credit)
    }
}
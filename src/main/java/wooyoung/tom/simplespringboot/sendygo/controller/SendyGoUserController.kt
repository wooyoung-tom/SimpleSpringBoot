package wooyoung.tom.simplespringboot.sendygo.controller

import org.springframework.web.bind.annotation.*
import wooyoung.tom.simplespringboot.sendygo.repository.user.SendyGoUser
import wooyoung.tom.simplespringboot.sendygo.dto.UserCreditRequest
import wooyoung.tom.simplespringboot.sendygo.service.SendyGoUserService

@RestController
open class SendyGoUserController(
    private val sendyGoUserService: SendyGoUserService
) {

    // 회원가입 및 로그인
    @PostMapping("/users/signing")
    open fun signingUser(@RequestBody sendyGoUser: SendyGoUser): SendyGoUser {
        return sendyGoUserService.signingUser(sendyGoUser)
    }

    // 랭킹 조회
    @GetMapping("/users/ranking")
    open fun getUserRankingList(): List<SendyGoUser> {
        return sendyGoUserService.getUserRankingList()
    }

    // 크레딧 업데이트 POST ver.
    @PostMapping("/users/update/credit")
    open fun updateUserCredit(@RequestBody userCreditInfo: UserCreditRequest): Int {
        return sendyGoUserService.updateUserCredit(userCreditInfo.id, userCreditInfo.credit)
    }

    // 크레딧 업데이트 PATCH ver.
    @PatchMapping("/users/{id}/credit")
    open fun patchUserCredit(@PathVariable id: String, @RequestBody credit: Long): Int {
        return sendyGoUserService.updateUserCredit(id, credit)
    }
}
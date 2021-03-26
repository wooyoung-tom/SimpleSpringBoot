package wooyoung.tom.simplespringboot.sendygo.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.sendygo.repository.user.SendyGoUser
import wooyoung.tom.simplespringboot.sendygo.repository.user.SendyGoUserRepository

@Service
open class SendyGoUserService(
    private val sendyGoUserRepository: SendyGoUserRepository
) {

    // 회원 가입 또는 로그인
    @Transactional
    open fun signingUser(sendyGoUser: SendyGoUser): SendyGoUser {
        val foundUser = sendyGoUserRepository.findUserById(sendyGoUser.id)

        // 유저가 존재하면 해당 유저 return
        return if (foundUser.isPresent) foundUser.get() else sendyGoUserRepository.create(sendyGoUser)
    }

    // 랭킹 조회
    open fun getUserRankingList(): List<SendyGoUser> {
        return sendyGoUserRepository.findAllUser()
    }

    // 크레딧 업데이트
    @Transactional
    open fun updateUserCredit(userId: String, credit: Long): Int {
        // 먼저 크레딧 계산을 위해서 유저정보를 id 사용하여 받아온다.
        val user = sendyGoUserRepository.findUserById(userId)

        return if (user.isPresent)
            sendyGoUserRepository.updateUserCredit(userId, user.get().credit + credit)
        else -1
    }
}
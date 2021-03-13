package wooyoung.tom.simplespringboot.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.domain.Response
import wooyoung.tom.simplespringboot.domain.User
import wooyoung.tom.simplespringboot.repository.user.UserRepository

@Service
open class UserService(
    private val userRepository: UserRepository
) {

    // 회원 가입 또는 로그인
    open fun signingUser(id: String): User {
        return userRepository.findUserById(id) ?: userRepository.createUser(id)
    }

    // 랭킹 조회
    open fun getUserRankingList(): List<User> {
        return userRepository.findAllUser()
    }

    // 크레딧 업데이트
    @Transactional
    open fun updateUserCredit(userId: String, credit: Long): Int {
        // 먼저 크레딧 계산을 위해서 유저정보를 id 사용하여 받아온다.
        val user = userRepository.findUserById(userId)
        // 유저 크레딧 계산한다.
        val updateCredit = user?.credit ?: 0 + credit

        return userRepository.updateUserCredit(userId, updateCredit)
    }
}
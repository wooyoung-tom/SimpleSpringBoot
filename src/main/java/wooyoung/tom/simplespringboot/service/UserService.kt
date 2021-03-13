package wooyoung.tom.simplespringboot.service

import org.springframework.stereotype.Service
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
    open fun updateUserCredit(userId: String, credit: Long): Int {
        return userRepository.updateUserCredit(userId, credit)
    }
}
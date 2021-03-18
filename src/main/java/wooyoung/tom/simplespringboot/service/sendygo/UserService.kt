package wooyoung.tom.simplespringboot.service.sendygo

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.repository.sendygo.user.User
import wooyoung.tom.simplespringboot.repository.sendygo.user.UserRepository

@Service
open class UserService(
    private val userRepository: UserRepository
) {

    // 회원 가입 또는 로그인
    @Transactional
    open fun signingUser(user: User): User {
        val foundUser = userRepository.findUserById(user.id)

        // 유저가 존재하면 해당 유저 return
        return if (foundUser.isPresent) foundUser.get() else userRepository.create(user)
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

        return if (user.isPresent)
            userRepository.updateUserCredit(userId, user.get().credit + credit)
        else -1
    }
}
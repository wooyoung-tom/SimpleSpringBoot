package wooyoung.tom.simplespringboot.service

import org.springframework.stereotype.Service
import wooyoung.tom.simplespringboot.domain.User
import wooyoung.tom.simplespringboot.repository.user.UserRepository

@Service
open class UserService(
    private val userRepository: UserRepository
) {

    // 회원 가입 또는 로그인
    open fun signingUser(user: User): User {
        return userRepository.findUserById(user.id) ?: userRepository.createUser(user.id)
    }
}
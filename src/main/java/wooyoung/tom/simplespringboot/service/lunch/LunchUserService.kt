package wooyoung.tom.simplespringboot.service.lunch

import org.springframework.stereotype.Service
import wooyoung.tom.simplespringboot.repository.lunch.user.LunchUserRepository
import wooyoung.tom.simplespringboot.repository.lunch.user.User

@Service
open class LunchUserService(
    private val lunchUserRepository: LunchUserRepository
) {

    // 유저 회원가입 프로세스
    fun join(user: User)
}
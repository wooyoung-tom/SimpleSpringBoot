package wooyoung.tom.simplespringboot.service.lunch

import org.springframework.stereotype.Service
import wooyoung.tom.simplespringboot.repository.lunch.user.LunchUserRepository

@Service
open class LunchUserService(
    private val lunchUserRepository: LunchUserRepository
) {

    // 유저 저장
}
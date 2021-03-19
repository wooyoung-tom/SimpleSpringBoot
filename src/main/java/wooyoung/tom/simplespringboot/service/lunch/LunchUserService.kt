package wooyoung.tom.simplespringboot.service.lunch

import org.springframework.stereotype.Service
import wooyoung.tom.simplespringboot.dto.lunch.user.LunchUserResponse
import wooyoung.tom.simplespringboot.repository.lunch.user.LunchUser
import wooyoung.tom.simplespringboot.repository.lunch.user.LunchUserRepository
import java.util.*

@Service
open class LunchUserService(
    private val lunchUserRepository: LunchUserRepository
) {

    open fun signInUser(name: String): LunchUserResponse {
        val result = lunchUserRepository.findById(name)

        return if (!result.isPresent) {
            LunchUserResponse(
                message = "해당 유저를 찾을 수 없습니다.",
                body = null
            )
        } else {
            LunchUserResponse(
                message = "$name 유저를 찾았습니다.",
                body = result.get()
            )
        }
    }
}
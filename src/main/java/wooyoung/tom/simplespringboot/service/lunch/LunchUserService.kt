package wooyoung.tom.simplespringboot.service.lunch

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
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

    @Transactional
    open fun signUpUser(user: LunchUser): LunchUserResponse {
        // ID 로 유저가 중복되는지 확인한다.
        val result = lunchUserRepository.findById(user.name)

        // Result 가 존재하면 회원가입 불가능 하다.
        return if (result.isPresent) {
            LunchUserResponse(
                message = "중복된 이름의 유저가 존재합니다.",
                body = null
            )
        }
        // Result 가 존재하지 않으면 회원 등록 진행한다.
        else {
            val saveResult = lunchUserRepository.save(user)
            LunchUserResponse(
                message = "${user.name} 등록을 완료하였습니다.",
                body = saveResult

            )
        }
    }
}
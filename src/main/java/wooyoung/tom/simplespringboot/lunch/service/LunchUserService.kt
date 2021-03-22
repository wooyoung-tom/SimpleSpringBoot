package wooyoung.tom.simplespringboot.lunch.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.lunch.dto.user.LunchUserResponse
import wooyoung.tom.simplespringboot.lunch.repository.history.LunchHistoryRepository
import wooyoung.tom.simplespringboot.lunch.repository.user.LunchUser
import wooyoung.tom.simplespringboot.lunch.repository.user.LunchUserRepository
import java.text.SimpleDateFormat
import java.util.*

@Service
open class LunchUserService(
    private val lunchUserRepository: LunchUserRepository,
    private val lunchHistoryRepository: LunchHistoryRepository
) {

    private fun getYesterdayDateForString(): String {
        return SimpleDateFormat("yyyy-MM-dd")
            .format(Calendar.getInstance().apply {
                time = Date()
                add(Calendar.DATE, -1)
            }.time).toString()
    }

    @Transactional
    open fun signInUser(name: String): LunchUserResponse {
        val userResult = lunchUserRepository.findById(name)

        // 유저가 있는지 먼저 확인한다.
        if (!userResult.isPresent) {
            return LunchUserResponse(
                selected = false,
                message = "해당 유저를 찾을 수 없습니다.",
                body = null,
            )
        } else {
            val historyResult = lunchHistoryRepository.findLunchHistoryByNameAndDate(
                name = userResult.get().name,
                date = getYesterdayDateForString()
            )

            return if (historyResult.isPresent) {
                LunchUserResponse(
                    selected = true,
                    message = "$name 유저를 찾았습니다.",
                    body = userResult.get()
                )
            } else {
                LunchUserResponse(
                    selected = false,
                    message = "$name 유저를 찾았습니다.",
                    body = userResult.get()
                )
            }
        }
    }

    @Transactional
    open fun signUpUser(user: LunchUser): LunchUserResponse {
        // ID 로 유저가 중복되는지 확인한다.
        val result = lunchUserRepository.findById(user.name)

        // Result 가 존재하면 회원가입 불가능 하다.
        return if (result.isPresent) {
            LunchUserResponse(
                selected = false,
                message = "중복된 이름의 유저가 존재합니다.",
                body = null
            )
        }
        // Result 가 존재하지 않으면 회원 등록 진행한다.
        else {
            val saveResult = lunchUserRepository.save(user)
            LunchUserResponse(
                selected = false,
                message = "${user.name} 등록을 완료하였습니다.",
                body = saveResult
            )
        }
    }
}
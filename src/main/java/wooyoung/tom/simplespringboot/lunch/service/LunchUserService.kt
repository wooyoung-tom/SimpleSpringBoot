package wooyoung.tom.simplespringboot.lunch.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.lunch.dto.user.LunchUserRequest
import wooyoung.tom.simplespringboot.lunch.dto.user.LunchUserResponse
import wooyoung.tom.simplespringboot.lunch.entity.LunchUser
import wooyoung.tom.simplespringboot.lunch.repository.LunchUserRepository
import java.time.LocalDate

@Service
open class LunchUserService(
    private val lunchUserRepository: LunchUserRepository
) {

    @Transactional
    open fun signUp(user: LunchUserRequest): LunchUserResponse {
        // 회원이 존재하는지 먼저 확인
        val findUser = lunchUserRepository.findById(user.name)

        return if (findUser.isPresent) {
            // 회원이 존재하면 null return
            LunchUserResponse(
                code = "FAILED",
                message = "${user.name} 을(를) 가진 유저가 이미 존재합니다.",
                body = null
            )
        } else {
            val newUser = LunchUser(user.name, user.teamName)
            val saveResult = lunchUserRepository.save(newUser)

            LunchUserResponse(
                code = "SUCCESS",
                message = "${user.name} 회원 등록을 완료했습니다.",
                body = saveResult
            )
        }
    }

    open fun signIn(userName: String): LunchUserResponse {
        val foundResult = lunchUserRepository.findById(userName)

        // 회원이 존재할 때
        if (foundResult.isPresent) {
            // 먼저 히스토리에 오늘 날짜랑 같은지 필터링 해야한다.
            val foundUser = foundResult.get()
            val todayHistory = foundUser.historyList.find { lunchHistory ->
                lunchHistory.selectedDate == LocalDate.now()
            }

            // 오늘 선택한 히스토리가 없으면 선택하러 갈 수 있도록 진행해야 함
            return if (todayHistory == null) {
                LunchUserResponse(
                    code = "FAILED",
                    message = "${userName}, 메뉴 선택이 필요합니다.",
                    body = foundUser
                )
            } else {
                // 오늘 선택한 히스토리가 있으면 SUCCESS Code
                LunchUserResponse(
                    code = "SUCCESS",
                    message = "$userName 로그인 완료되었습니다.",
                    body = foundUser
                )
            }
        } else {
            // 회원이 존재하지 않으면
            return LunchUserResponse(
                code = "FAILED",
                message = "$userName, 가입이 필요합니다.",
                body = null
            )
        }
    }
}
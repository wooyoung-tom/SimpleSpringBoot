package wooyoung.tom.simplespringboot.lunch.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.lunch.dto.history.LunchHistoryRequest
import wooyoung.tom.simplespringboot.lunch.dto.history.LunchHistoryResponse
import wooyoung.tom.simplespringboot.lunch.entity.LunchHistory
import wooyoung.tom.simplespringboot.lunch.repository.LunchHistoryRepository
import wooyoung.tom.simplespringboot.lunch.repository.LunchUserRepository

@Service
open class LunchHistoryService(
    private val lunchUserRepository: LunchUserRepository,
    private val lunchHistoryRepository: LunchHistoryRepository
) {

    @Transactional
    open fun registerHistory(id: String, history: LunchHistoryRequest): LunchHistoryResponse {
        val foundUserResult = lunchUserRepository.findById(id)

        // 유저 이름으로 유저 찾아야 한다.
        if (foundUserResult.isPresent) {
            val foundUser = foundUserResult.get()
            val newHistory = LunchHistory(
                user = foundUser,
                selectedCategory = history.selectedCategory,
                selectedDate = history.selectedDate
            )

            val historySaveResult = lunchHistoryRepository.save(newHistory)

            return LunchHistoryResponse(
                code = "SUCCESS",
                message = "${id}의 히스토리를 저장하였습니다.",
                body = historySaveResult
            )
        } else {
            return LunchHistoryResponse(
                code = "FAILED",
                message = "${id}를 찾을 수 없습니다.",
                body = null
            )
        }
    }
}
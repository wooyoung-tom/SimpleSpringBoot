package wooyoung.tom.simplespringboot.lunch.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.lunch.dto.history.LunchHistoryRequest
import wooyoung.tom.simplespringboot.lunch.dto.history.LunchHistoryNetworkResponse
import wooyoung.tom.simplespringboot.lunch.dto.history.LunchHistoryResponse
import wooyoung.tom.simplespringboot.lunch.entity.LunchHistory
import wooyoung.tom.simplespringboot.lunch.entity.LunchTeam
import wooyoung.tom.simplespringboot.lunch.repository.LunchHistoryRepository
import wooyoung.tom.simplespringboot.lunch.repository.LunchTeamRepository
import wooyoung.tom.simplespringboot.lunch.repository.LunchUserRepository

@Service
open class LunchHistoryService(
    private val lunchUserRepository: LunchUserRepository,
    private val lunchHistoryRepository: LunchHistoryRepository,
    private val lunchTeamRepository: LunchTeamRepository
) {

    @Transactional
    open fun registerHistory(
        id: String,
        history: LunchHistoryRequest
    ): LunchHistoryNetworkResponse<LunchHistoryResponse> {
        val foundUserResult = lunchUserRepository.findById(id)

        // 유저 이름으로 유저 찾아야 한다.
        if (foundUserResult.isPresent) {
            val foundUser = foundUserResult.get()

            val newHistory = LunchHistory(
                user = foundUser,
                selectedCategory = history.selected_category,
                selectedDate = history.selected_date,
                historyTeam = foundUser.userTeam ?: LunchTeam("default_team")
            )

            val historySaveResult = lunchHistoryRepository.save(newHistory)

            return LunchHistoryNetworkResponse(
                code = "SUCCESS",
                message = "${id}의 히스토리를 저장하였습니다.",
                body = LunchHistoryResponse(
                    historySaveResult.id,
                    historySaveResult.user,
                    historySaveResult.selectedCategory,
                    historySaveResult.selectedDate
                )
            )
        } else {
            return LunchHistoryNetworkResponse(
                code = "FAILED",
                message = "${id}를 찾을 수 없습니다.",
                body = null
            )
        }
    }

    @Transactional
    open fun getAllTeamHistories(teamName: String) {
        // 총 팀원 수를 구하기 위해서 team repository 불러온다.
        val foundTeamResult = lunchTeamRepository.findById(teamName)

        val teamMemberCnt = if (foundTeamResult.isPresent) {
            foundTeamResult.get().userList.size
        } else 0
    }
}
package wooyoung.tom.simplespringboot.lunch.service

import org.springframework.stereotype.Service
import wooyoung.tom.simplespringboot.lunch.dto.history.LunchHistoryResponse
import wooyoung.tom.simplespringboot.lunch.dto.history.LunchTeamHistoryResponse
import wooyoung.tom.simplespringboot.lunch.repository.history.LunchHistory
import wooyoung.tom.simplespringboot.lunch.repository.history.LunchHistoryRepository
import java.util.*

@Service
open class LunchHistoryService(
    private val lunchHistoryRepository: LunchHistoryRepository
) {

    // 히스토리 저장
    open fun saveHistory(history: LunchHistory): LunchHistoryResponse {
        val result = lunchHistoryRepository.save(history)

        return LunchHistoryResponse(
            message = "${result.name}의 ${result.category} 추가 완료했습니다.",
            body = result
        )
    }

    // 팀원들이 어떤 것을 선택했는지 가져온다.
    open fun findLunchHistoriesByTeamNameAndDate(teamName: String, date: String): LunchTeamHistoryResponse {
        val result = lunchHistoryRepository.findLunchHistoriesByTeamNameAndDate(teamName, date)

        return LunchTeamHistoryResponse(
            message = "${result.size}개의 결과를 찾았습니다.",
            body = result
        )
    }
}
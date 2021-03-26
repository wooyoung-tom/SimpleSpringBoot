package wooyoung.tom.simplespringboot.lunch.repository.history

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import wooyoung.tom.simplespringboot.lunch.dto.history.LunchHistoryResult
import wooyoung.tom.simplespringboot.lunch.repository.SqlQueries
import java.util.*

interface LunchHistoryRepository : JpaRepository<LunchHistory, Long> {

    // 자신 이름과 날짜를 통해 이미 입력이 되어있는지 아닌지 확인하기 위한 함수
    fun findLunchHistoryByNameAndDate(name: String, date: String): Optional<LunchHistory>

    // 팀 이름과 날짜를 통해 팀원들이 어떤 카테고리를 골랐는지 가져온다.
    fun findLunchHistoriesByTeamNameAndDate(teamName: String, date: String): List<LunchHistory>

    @Query(SqlQueries.findLunchHistoryResultByTeamNameAndDateGroupByCategory)
    fun findHistoryCount(teamName: String, date: String): List<LunchHistoryResult>
}
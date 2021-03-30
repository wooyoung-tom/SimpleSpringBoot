package wooyoung.tom.simplespringboot.lunch.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import wooyoung.tom.simplespringboot.lunch.entity.LunchHistory
import wooyoung.tom.simplespringboot.lunch.entity.LunchHistoryGroupBy
import wooyoung.tom.simplespringboot.lunch.entity.LunchTeam
import java.time.LocalDate

interface LunchHistoryRepository : JpaRepository<LunchHistory, Long> {

    // 팀 이름과 오늘 날짜를 통해 히스토리 리스트 검색
    fun findLunchHistoriesByHistoryTeamAndSelectedDate(
        historyTeam: LunchTeam, selectedDate: LocalDate
    ): List<LunchHistory>

    // 카테고리별 Group By
    @Query(
        value = "SELECT COUNT(h.selected_category) AS count, h.selected_category AS category " +
                "FROM lunch_history h " +
                "WHERE h.team_name = ?1 AND h.selected_date = ?2 " +
                "GROUP BY h.selected_category",
        nativeQuery = true
    )
    fun findLunchHistoriesByHistoryTeamAndSelectedDateGroupBySelectedCategory(
        teamName: String, selectedDate: LocalDate
    ): List<LunchHistoryGroupBy>
}
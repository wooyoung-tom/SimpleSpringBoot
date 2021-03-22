package wooyoung.tom.simplespringboot.lunch.controller

import org.springframework.web.bind.annotation.*
import retrofit2.http.Query
import wooyoung.tom.simplespringboot.lunch.dto.history.LunchHistoryRequest
import wooyoung.tom.simplespringboot.lunch.dto.history.LunchHistoryResponse
import wooyoung.tom.simplespringboot.lunch.dto.history.LunchTeamHistoryResponse
import wooyoung.tom.simplespringboot.lunch.repository.history.LunchHistory
import wooyoung.tom.simplespringboot.lunch.service.LunchHistoryService

@RestController
open class LunchHistoryController(
    private val lunchHistoryService: LunchHistoryService
) {

    @PostMapping("/lunch/history")
    open fun saveHistory(@RequestBody history: LunchHistoryRequest): LunchHistoryResponse {
        val newHistory = LunchHistory(
            history.name,
            history.team_name,
            history.date,
            history.category
        )

        return lunchHistoryService.saveHistory(history = newHistory)
    }

    @GetMapping("/lunch/history")
    open fun findHistoryByTeamNameAndDate(
        @RequestParam("team_name") teamName: String,
        @RequestParam("date") date: String
    ): LunchTeamHistoryResponse {
        return lunchHistoryService.findLunchHistoriesByTeamNameAndDate(teamName, date)
    }
}
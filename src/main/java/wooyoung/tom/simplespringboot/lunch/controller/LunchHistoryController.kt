package wooyoung.tom.simplespringboot.lunch.controller

import org.springframework.web.bind.annotation.*
import wooyoung.tom.simplespringboot.lunch.dto.history.LunchHistoryRequest
import wooyoung.tom.simplespringboot.lunch.dto.history.LunchHistoryResponse
import wooyoung.tom.simplespringboot.lunch.dto.history.LunchHistoryResultResponse
import wooyoung.tom.simplespringboot.lunch.repository.history.LunchHistory
import wooyoung.tom.simplespringboot.lunch.service.LunchHistoryService
import wooyoung.tom.simplespringboot.utils.getYesterdayDateForString

@RestController
open class LunchHistoryController(
    private val lunchHistoryService: LunchHistoryService
) {

    @PostMapping("/lunch/history")
    open fun saveHistory(@RequestBody history: LunchHistoryRequest): LunchHistoryResponse {
        val newHistory = LunchHistory(
            history.name,
            history.teamName,
            history.date,
            history.category
        )

        return lunchHistoryService.saveHistory(history = newHistory)
    }

    @GetMapping("/lunch/history")
    open fun findHistoryByTeamNameAndDate(
        @RequestParam("teamName") teamName: String
    ): LunchHistoryResultResponse {
        val date = getYesterdayDateForString()
        return lunchHistoryService.findLunchHistoriesByTeamNameAndDate(teamName, date)
    }
}
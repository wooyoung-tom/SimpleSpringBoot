package wooyoung.tom.simplespringboot.lunch.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import wooyoung.tom.simplespringboot.lunch.dto.history.LunchHistoryRequest
import wooyoung.tom.simplespringboot.lunch.repository.history.LunchHistory
import wooyoung.tom.simplespringboot.lunch.service.LunchHistoryService

@RestController
open class LunchHistoryController(
    private val lunchHistoryService: LunchHistoryService
) {

    @PostMapping("/lunch/history")
    open fun saveHistory(@RequestBody history: LunchHistoryRequest): LunchHistory {
        val newHistory = LunchHistory(
            history.name,
            history.teamName,
            history.historyDate,
            history.category
        )
        return lunchHistoryService.saveHistory(history = newHistory)
    }
}
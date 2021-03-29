package wooyoung.tom.simplespringboot.lunch.controller

import org.springframework.web.bind.annotation.*
import wooyoung.tom.simplespringboot.lunch.dto.history.LunchHistoryRequest
import wooyoung.tom.simplespringboot.lunch.dto.history.LunchHistoryResponse
import wooyoung.tom.simplespringboot.lunch.service.LunchHistoryService

@RestController
open class LunchHistoryController(
    private val lunchHistoryService: LunchHistoryService
) {

    @PostMapping("/lunch/history/{id}")
    open fun registerHistory(
        @PathVariable id: String,
        @RequestBody request: LunchHistoryRequest
    ): LunchHistoryResponse {
        return lunchHistoryService.registerHistory(id, request)
    }
}
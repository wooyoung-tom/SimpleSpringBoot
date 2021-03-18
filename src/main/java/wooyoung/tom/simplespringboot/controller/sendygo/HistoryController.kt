package wooyoung.tom.simplespringboot.controller.sendygo

import org.springframework.web.bind.annotation.*
import wooyoung.tom.simplespringboot.repository.sendygo.history.History
import wooyoung.tom.simplespringboot.dto.sendygo.HistoryRequest
import wooyoung.tom.simplespringboot.service.sendygo.HistoryService

@RestController
open class HistoryController(
    private val historyService: HistoryService
) {

    // 유저 히스토리 리스트
    @GetMapping("/history/{id}")
    open fun getUserHistoryList(@PathVariable id: String): List<History> {
        return historyService.getAllHistoryByUserId(id)
    }

    // 히스토리 저장하는 함수
    @PostMapping("/history/save")
    open fun createUserHistory(@RequestBody history: HistoryRequest): Long {
        return historyService.saveUserHistory(history)
    }
}
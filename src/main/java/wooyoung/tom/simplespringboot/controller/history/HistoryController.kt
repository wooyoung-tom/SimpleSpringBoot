package wooyoung.tom.simplespringboot.controller.history

import org.springframework.web.bind.annotation.*
import wooyoung.tom.simplespringboot.domain.History
import wooyoung.tom.simplespringboot.dto.HistoryRequestDTO
import wooyoung.tom.simplespringboot.service.HistoryService

@RestController
open class HistoryController(
    private val historyService: HistoryService
) {

    // 유저 히스토리 리스트
    @GetMapping("/history/my")
    open fun getUserHistoryList(@RequestHeader id: String): List<History> {
        return historyService.getAllHistoryByUserId(id)
    }

    // 히스토리 저장하는 함수
    @PostMapping("/history/save")
    open fun createUserHistory(@RequestBody history: HistoryRequestDTO): Long {
        return historyService.saveUserHistory(history)
    }
}
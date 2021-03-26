package wooyoung.tom.simplespringboot.sendygo.controller

import org.springframework.web.bind.annotation.*
import wooyoung.tom.simplespringboot.sendygo.repository.history.SendyGoHistory
import wooyoung.tom.simplespringboot.sendygo.dto.HistoryRequest
import wooyoung.tom.simplespringboot.sendygo.service.SendyGoHistoryService

@RestController
open class SendyGoHistoryController(
    private val sendyGoHistoryService: SendyGoHistoryService
) {

    // 유저 히스토리 리스트
    @GetMapping("/history/{id}")
    open fun getUserHistoryList(@PathVariable id: String): List<SendyGoHistory> {
        return sendyGoHistoryService.getAllHistoryByUserId(id)
    }

    // 히스토리 저장하는 함수
    @PostMapping("/history/save")
    open fun createUserHistory(@RequestBody history: HistoryRequest): Long {
        return sendyGoHistoryService.saveUserHistory(history)
    }
}
package wooyoung.tom.simplespringboot.sendygo.service

import org.springframework.stereotype.Service
import wooyoung.tom.simplespringboot.sendygo.repository.history.History
import wooyoung.tom.simplespringboot.sendygo.dto.HistoryRequest
import wooyoung.tom.simplespringboot.sendygo.repository.history.HistoryRepository

@Service
open class HistoryService(
    private val historyRepository: HistoryRepository
) {

    // 유저 아이디를 통해 해당 유저의 히스토리 모두 가져오는 함수
    open fun getAllHistoryByUserId(userId: String): List<History> {
        return historyRepository.findAllHistoryByUserId(userId)
    }

    // 히스토리 저장
    open fun saveUserHistory(history: HistoryRequest): Long {
        return historyRepository.createHistory(history)
    }
}
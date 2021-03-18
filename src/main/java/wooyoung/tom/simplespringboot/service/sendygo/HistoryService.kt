package wooyoung.tom.simplespringboot.service.sendygo

import org.springframework.stereotype.Service
import wooyoung.tom.simplespringboot.repository.sendygo.history.History
import wooyoung.tom.simplespringboot.dto.HistoryRequestDTO
import wooyoung.tom.simplespringboot.repository.sendygo.history.HistoryRepository

@Service
open class HistoryService(
    private val historyRepository: HistoryRepository
) {

    // 유저 아이디를 통해 해당 유저의 히스토리 모두 가져오는 함수
    open fun getAllHistoryByUserId(userId: String): List<History> {
        return historyRepository.findAllHistoryByUserId(userId)
    }

    // 히스토리 저장
    open fun saveUserHistory(history: HistoryRequestDTO): Long {
        return historyRepository.createHistory(history)
    }
}
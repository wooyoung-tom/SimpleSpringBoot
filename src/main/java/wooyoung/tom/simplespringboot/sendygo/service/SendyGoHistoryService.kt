package wooyoung.tom.simplespringboot.sendygo.service

import org.springframework.stereotype.Service
import wooyoung.tom.simplespringboot.sendygo.repository.history.SendyGoHistory
import wooyoung.tom.simplespringboot.sendygo.dto.HistoryRequest
import wooyoung.tom.simplespringboot.sendygo.repository.history.SendyGoHistoryRepository

@Service
open class SendyGoHistoryService(
    private val sendyGoHistoryRepository: SendyGoHistoryRepository
) {

    // 유저 아이디를 통해 해당 유저의 히스토리 모두 가져오는 함수
    open fun getAllHistoryByUserId(userId: String): List<SendyGoHistory> {
        return sendyGoHistoryRepository.findAllHistoryByUserId(userId)
    }

    // 히스토리 저장
    open fun saveUserHistory(history: HistoryRequest): Long {
        return sendyGoHistoryRepository.createHistory(history)
    }
}
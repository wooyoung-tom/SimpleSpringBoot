package wooyoung.tom.simplespringboot.lunch.service

import org.springframework.stereotype.Service
import wooyoung.tom.simplespringboot.lunch.repository.history.LunchHistory
import wooyoung.tom.simplespringboot.lunch.repository.history.LunchHistoryRepository

@Service
open class LunchHistoryService(
    private val lunchHistoryRepository: LunchHistoryRepository
) {

    // 히스토리 저장
    open fun saveHistory(history: LunchHistory): LunchHistory {
        return lunchHistoryRepository.save(history)
    }
}
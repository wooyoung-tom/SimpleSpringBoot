package wooyoung.tom.simplespringboot.repository.sendygo.history

import wooyoung.tom.simplespringboot.dto.HistoryRequestDTO

interface HistoryRepository {

    // Create
    fun createHistory(history: HistoryRequestDTO): Long

    // Read
    fun findAllHistoryByUserId(userId: String): List<History>

    // Update

    // Delete
}
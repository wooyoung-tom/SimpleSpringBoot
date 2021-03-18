package wooyoung.tom.simplespringboot.repository.sendygo.history

import wooyoung.tom.simplespringboot.dto.sendygo.HistoryRequest

interface HistoryRepository {

    // Create
    fun createHistory(history: HistoryRequest): Long

    // Read
    fun findAllHistoryByUserId(userId: String): List<History>

    // Update

    // Delete
}
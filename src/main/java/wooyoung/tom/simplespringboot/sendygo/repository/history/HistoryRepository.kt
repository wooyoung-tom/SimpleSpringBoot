package wooyoung.tom.simplespringboot.sendygo.repository.history

import wooyoung.tom.simplespringboot.sendygo.dto.HistoryRequest

interface HistoryRepository {

    // Create
    fun createHistory(history: HistoryRequest): Long

    // Read
    fun findAllHistoryByUserId(userId: String): List<History>

    // Update

    // Delete
}
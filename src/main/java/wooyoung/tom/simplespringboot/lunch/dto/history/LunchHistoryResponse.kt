package wooyoung.tom.simplespringboot.lunch.dto.history

import wooyoung.tom.simplespringboot.lunch.repository.history.LunchHistory

data class LunchHistoryResponse(
    val message: String,
    val body: LunchHistory
)
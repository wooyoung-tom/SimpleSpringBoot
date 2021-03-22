package wooyoung.tom.simplespringboot.lunch.dto.history

import wooyoung.tom.simplespringboot.lunch.repository.history.LunchHistory

data class LunchTeamHistoryResponse(
    val message: String,
    val body: List<LunchHistory>
)
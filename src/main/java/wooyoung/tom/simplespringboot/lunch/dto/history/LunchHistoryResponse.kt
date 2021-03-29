package wooyoung.tom.simplespringboot.lunch.dto.history

import wooyoung.tom.simplespringboot.lunch.entity.LunchHistory

data class LunchHistoryResponse(
    val code: String,
    val message: String,
    val body: LunchHistory?
)
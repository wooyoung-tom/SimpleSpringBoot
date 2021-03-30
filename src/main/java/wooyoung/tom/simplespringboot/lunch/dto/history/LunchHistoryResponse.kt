package wooyoung.tom.simplespringboot.lunch.dto.history

import wooyoung.tom.simplespringboot.lunch.entity.LunchUser
import java.time.LocalDate

data class LunchHistoryResponse(
    val id: Long?,
    val user: LunchUser,
    val selected_category: String,
    val selected_date: LocalDate
)
package wooyoung.tom.simplespringboot.lunch.dto.history

import java.time.LocalDate

data class LunchHistoryRequest(
    val selected_category: String,
    val selected_date: LocalDate
)
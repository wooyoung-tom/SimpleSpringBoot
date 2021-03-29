package wooyoung.tom.simplespringboot.lunch.dto.history

import java.time.LocalDate

data class LunchHistoryRequest(
    val selectedCategory: String,
    val selectedDate: LocalDate
)

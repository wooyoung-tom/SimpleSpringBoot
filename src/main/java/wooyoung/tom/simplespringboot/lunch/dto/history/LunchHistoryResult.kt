package wooyoung.tom.simplespringboot.lunch.dto.history

data class LunchHistoryResult(
    val category: String,
    val teamName: String,
    val count: Long,
    val date: String
)
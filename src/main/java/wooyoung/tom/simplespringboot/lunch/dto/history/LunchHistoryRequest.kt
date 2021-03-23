package wooyoung.tom.simplespringboot.lunch.dto.history

data class LunchHistoryRequest(
    val name: String,
    val teamName: String,
    val date: String,
    val category: String
)

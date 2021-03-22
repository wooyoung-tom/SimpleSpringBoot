package wooyoung.tom.simplespringboot.lunch.dto.history

data class LunchHistoryRequest(
    val name: String,
    val team_name: String,
    val date: String,
    val category: String
)

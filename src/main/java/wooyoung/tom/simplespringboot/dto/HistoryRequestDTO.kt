package wooyoung.tom.simplespringboot.dto

data class HistoryRequestDTO(
    val userId: String,
    val duration: String,
    val srcName: String,
    val destName: String,
    val distance: String,
    val credit: Long,
    val historyTime: String,
    val historyDate: String
)
package wooyoung.tom.simplespringboot.sendygo.dto

data class HistoryRequest(
    val userId: String,
    val duration: String,
    val srcName: String,
    val destName: String,
    val distance: String,
    val credit: Long,
    val historyTime: String,
    val historyDate: String
)
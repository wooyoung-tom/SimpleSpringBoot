package wooyoung.tom.simplespringboot.lunch.dto.history

data class LunchHistoryResultResponse(
    val meta: LunchHistoryResultMeta,
    val message: String,
    val body: List<LunchHistoryResult>
)
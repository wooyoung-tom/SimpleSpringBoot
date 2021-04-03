package wooyoung.tom.simplespringboot.utils

data class PagedMetaData(
    val end: Boolean,
    val totalResults: Long,
    val totalPages: Int,
    val page: Int,
    val size: Int
)
package wooyoung.tom.simplespringboot.domain

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class History(
    @Id val id: Long,
    val userId: String,
    val duration: String,
    val srcName: String,
    val destName: String,
    val distance: String,
    val credit: Long,
    val historyTime: String,
    val historyDate: String
)
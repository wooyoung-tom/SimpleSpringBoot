package wooyoung.tom.simplespringboot.sendygo.repository.history

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class SendyGoHistory(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val userId: String = "user_id",

    val duration: String = "duration",

    val srcName: String = "source_name",

    val destName: String = "destination_name",

    val distance: String = "distance",

    val credit: Long = 0,

    val historyTime: String = "history_time",

    val historyDate: String = "history_date"
)
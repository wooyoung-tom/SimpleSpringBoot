package wooyoung.tom.simplespringboot.sendygo.repository.location

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "sendygo_location")
class SendyGoLocation(
    @Id
    val id: Long = 0,
    val lnglat: String,
    val name: String
)
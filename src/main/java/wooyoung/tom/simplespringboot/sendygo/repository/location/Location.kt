package wooyoung.tom.simplespringboot.sendygo.repository.location

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Location(
    @Id
    val id: Long = 0,
    val lnglat: String,
    val name: String
)
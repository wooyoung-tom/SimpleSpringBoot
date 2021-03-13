package wooyoung.tom.simplespringboot.domain

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Location(
    @Id
    val id: Long = 0,
    val lnglat: String,
    val name: String
)
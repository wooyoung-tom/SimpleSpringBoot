package wooyoung.tom.simplespringboot.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class User(
    @Id
    @Column
    val id: String,
    val credit: Long = 0,
    val accumulated_credit: Long = 0,
    val rank: Long = 0,
)
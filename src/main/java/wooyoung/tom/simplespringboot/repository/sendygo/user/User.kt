package wooyoung.tom.simplespringboot.repository.sendygo.user

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
class User(
    @Id
    @Column
    val id: String,
    var credit: Long = 0,
    var accumulated_credit: Long = 0,
    var rank: Long = 0,
)
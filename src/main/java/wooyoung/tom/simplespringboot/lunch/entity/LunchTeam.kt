package wooyoung.tom.simplespringboot.lunch.entity

import javax.persistence.*

@Entity
@Table(name = "lunch_team")
class LunchTeam(

    @Id
    val name: String,

    @OneToMany(mappedBy = "userTeam")
    val userList: List<LunchUser> = ArrayList(),

    @OneToMany(mappedBy = "historyTeam")
    val historyList: List<LunchHistory> = ArrayList()
)
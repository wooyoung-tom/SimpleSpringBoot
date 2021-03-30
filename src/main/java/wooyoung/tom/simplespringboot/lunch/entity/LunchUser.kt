package wooyoung.tom.simplespringboot.lunch.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "lunch_user")
class LunchUser(

    @Id
    val name: String,

    @ManyToOne
    @JoinColumn(name = "team_name")
    @JsonIgnore
    val userTeam: LunchTeam? = null,

    @OneToMany(mappedBy = "user")
    val historyList: List<LunchHistory> = ArrayList()
)
package wooyoung.tom.simplespringboot.lunch.repository.user

import javax.persistence.*

@Entity
@Table(name = "lunch_user")
class LunchUser(
    @Id
    val name: String,
    @Column(name = "team_name")
    val teamName: String
)
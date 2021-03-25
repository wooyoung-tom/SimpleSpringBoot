package wooyoung.tom.simplespringboot.lunch.repository.user

import javax.persistence.*

@Entity
@Table(name = "LUNCH_USER")
class LunchUser(
    @Id
    @Column(name = "name")
    val name: String,
    @Column(name = "team_name")
    val teamName: String
)
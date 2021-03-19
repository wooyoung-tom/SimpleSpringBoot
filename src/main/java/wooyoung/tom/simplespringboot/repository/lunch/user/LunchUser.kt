package wooyoung.tom.simplespringboot.repository.lunch.user

import javax.persistence.*

@Entity
@Table(name = "lunch_user")
class LunchUser(
    @Id
    val name: String,
    val team_name: String
)
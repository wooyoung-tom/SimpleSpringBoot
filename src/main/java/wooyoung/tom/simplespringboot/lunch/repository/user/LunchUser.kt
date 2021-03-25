package wooyoung.tom.simplespringboot.lunch.repository.user

import javax.persistence.*

@Entity
@Table(name = "LUNCH_USER")
class LunchUser(
    @Column(name = "name")
    val name: String,
    @Column(name = "team_name")
    val teamName: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}
package wooyoung.tom.simplespringboot.lunch.repository.history

import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "LUNCH_HISTORY")
class LunchHistory(
    @Column(name = "name")
    val name: String,

    @Column(name = "team_name")
    val teamName: String,

    @Column(name = "date")
    val date: String,

    @Column(name = "category")
    val category: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}
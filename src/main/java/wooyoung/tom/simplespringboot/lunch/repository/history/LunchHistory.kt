package wooyoung.tom.simplespringboot.lunch.repository.history

import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "lunch_history")
class LunchHistory(
    @Column(name = "name")
    val name: String,

    @Column(name = "team_name")
    val teamName: String,

    @Column(name = "h_date")
    val hDate: String,

    @Column(name = "category")
    val category: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}
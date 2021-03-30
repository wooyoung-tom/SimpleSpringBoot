package wooyoung.tom.simplespringboot.lunch.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "lunch_history")
class LunchHistory(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "selected_category")
    val selectedCategory: String,

    @Column(name = "selected_date")
    val selectedDate: LocalDate,

    @ManyToOne
    @JoinColumn(name = "user_name")
    @JsonIgnore
    val user: LunchUser,

    @ManyToOne
    @JoinColumn(name = "team_name")
    @JsonIgnore
    val historyTeam: LunchTeam
)
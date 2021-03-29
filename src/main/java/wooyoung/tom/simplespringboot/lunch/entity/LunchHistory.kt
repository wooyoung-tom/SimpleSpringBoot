package wooyoung.tom.simplespringboot.lunch.entity

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "lunch_history")
class LunchHistory(

    @ManyToOne
    @JoinColumn(name = "user_name")
    val user: LunchUser,

    @Column(name = "selected_category")
    val selectedCategory: String,

    @Column(name = "selected_date")
    val selectedDate: LocalDate
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}
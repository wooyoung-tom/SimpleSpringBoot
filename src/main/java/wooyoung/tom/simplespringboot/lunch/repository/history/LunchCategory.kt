package wooyoung.tom.simplespringboot.lunch.repository.history

import javax.persistence.*

@Entity
@Table(name = "LUNCH_CATEGORY")
class LunchCategory(
    val name: String
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null
}

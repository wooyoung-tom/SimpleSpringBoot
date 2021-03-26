package wooyoung.tom.simplespringboot.lunch.repository.category

import javax.persistence.*

@Entity
@Table(name = "LUNCH_CATEGORY")
class LunchCategory(
    @Column(name = "name")
    val name: String
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null
}
package wooyoung.tom.simplespringboot.lunch.repository.selected

import javax.persistence.*

@Entity
@Table(name = "LUNCH_SELECTED")
class LunchSelected(

) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}
package wooyoung.tom.simplespringboot.repository.lunch.user

import javax.persistence.*

@Entity
class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var name: String? = null
}
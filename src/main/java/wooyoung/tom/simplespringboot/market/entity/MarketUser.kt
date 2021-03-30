package wooyoung.tom.simplespringboot.market.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "market_user")
class MarketUser(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "username")
    val name: String,

    @JsonIgnore
    @Column(name = "pass")
    val password: String,

    @JsonIgnore
    @Column(name = "activated")
    val activated: Boolean,

    @Column(name = "access_token")
    val accessToken: String
)
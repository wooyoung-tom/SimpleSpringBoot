package wooyoung.tom.simplespringboot.market.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "market_user")
data class MarketUser(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "username")
    val name: String,

    @JsonIgnore
    @Column(name = "password")
    val password: String,

    @JsonIgnore
    @OneToMany(mappedBy = "userId")
    val favoriteList: List<MarketFavorite> = ArrayList(),
)
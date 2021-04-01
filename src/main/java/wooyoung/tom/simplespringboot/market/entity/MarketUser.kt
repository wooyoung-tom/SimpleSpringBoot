package wooyoung.tom.simplespringboot.market.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "market_user")
data class MarketUser(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "username")
    val name: String,

    @JsonIgnore
    @Column(name = "password")
    val password: String,

    @JsonIgnore
    @OneToMany(mappedBy = "favoriteMarketUser")
    val favoriteList: List<MarketFavorite> = ArrayList()
)
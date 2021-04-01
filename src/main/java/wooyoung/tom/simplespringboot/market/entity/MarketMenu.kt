package wooyoung.tom.simplespringboot.market.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "market_menu")
data class MarketMenu(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "name")
    val name: String,

    @Column(name = "price")
    val price: Int,

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @JsonIgnore
    val menuMarketRestaurant: MarketRestaurant
)
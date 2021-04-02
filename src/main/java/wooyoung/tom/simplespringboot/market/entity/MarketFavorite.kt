package wooyoung.tom.simplespringboot.market.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "market_favorite")
data class MarketFavorite(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "user_id")
    @JsonIgnore
    val userId: Long,

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    val favoriteMarketRestaurant: MarketRestaurant
)
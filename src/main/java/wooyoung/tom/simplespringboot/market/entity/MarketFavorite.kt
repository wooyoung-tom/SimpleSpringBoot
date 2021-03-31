package wooyoung.tom.simplespringboot.market.entity

import javax.persistence.*

@Entity
@Table(name = "market_favorite")
data class MarketFavorite(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val favoriteMarketUser: MarketUser,

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    val favoriteMarketRestaurant: MarketRestaurant
)
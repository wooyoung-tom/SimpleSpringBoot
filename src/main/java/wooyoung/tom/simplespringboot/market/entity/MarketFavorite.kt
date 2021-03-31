package wooyoung.tom.simplespringboot.market.entity

import javax.persistence.*

@Entity
@Table(name = "market_favorite")
class MarketFavorite(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "restaurant_id")
    val restaurantId: Long
) {

    @ManyToOne
    @JoinColumn(name = "user_id")
    val favoriteUser: MarketUser? = null
}
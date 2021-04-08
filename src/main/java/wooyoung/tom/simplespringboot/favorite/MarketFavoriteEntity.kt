package wooyoung.tom.simplespringboot.favorite

import wooyoung.tom.simplespringboot.restaurant.MarketRestaurantEntity
import javax.persistence.*

@Entity
@Table(name = "market_favorite")
data class MarketFavoriteEntity(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    // favorite 는 user 알 필요가 아직은 없다.
    @Column(name = "user_id")
    val userId: Long,

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    val restaurant: MarketRestaurantEntity,

    @Column(name = "status")
    var status: Boolean = true
)
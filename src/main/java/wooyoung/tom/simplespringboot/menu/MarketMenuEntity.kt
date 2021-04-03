package wooyoung.tom.simplespringboot.menu

import com.fasterxml.jackson.annotation.JsonIgnore
import wooyoung.tom.simplespringboot.restaurant.MarketRestaurantEntity
import javax.persistence.*

@Entity
@Table(name = "market_menu")
data class MarketMenuEntity(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "name")
    val name: String,

    @Column(name = "price")
    val price: Int,

    /**
     * @see restaurantInMenu restaurant_id (FK)로 restaurant 정보 가져온다.
     */
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    val restaurantInMenu: MarketRestaurantEntity
)

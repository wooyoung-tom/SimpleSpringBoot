package wooyoung.tom.simplespringboot.menu

import javax.persistence.*

@Entity
@Table(name = "market_menu")
data class MarketMenuEntity(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    /**
     * @see restaurantId restaurant_id (FK)
     */
    @Column(name = "restaurant_id")
    val restaurantId: Long,

    @Column(name = "name")
    val name: String,

    @Column(name = "price")
    val price: Int,
)
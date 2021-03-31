package wooyoung.tom.simplespringboot.market.entity

import javax.persistence.*

@Entity
@Table(name = "market_menu")
class MarketMenu(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "restaurant_id")
    val restaurantId: Long,

    @Column(name = "name")
    val name: String,

    @Column(name = "price")
    val price: Int
)
package wooyoung.tom.simplespringboot.market.entity

import javax.persistence.*

@Entity
@Table(name = "market_order_detail")
data class MarketOrderDetail(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "order_id")
    val orderId: Long,

    @Column(name = "menu_id")
    val menuId: Long,

    @Column(name = "menu_cnt")
    val menuCount: Int
)
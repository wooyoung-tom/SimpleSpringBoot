package wooyoung.tom.simplespringboot.order.detail

import javax.persistence.*

@Entity
@Table(name = "market_order_detail")
data class MarketOrderDetailEntity(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val Id: Long = 0,

    /**
     * TODO order_id, menu_id 연관관계 설정
     */
    @Column(name = "order_id")
    val orderId: Long,

    @Column(name = "menu_id")
    val menuId: Long,

    @Column(name = "menu_cnt")
    val menuCount: Int
)
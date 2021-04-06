package wooyoung.tom.simplespringboot.order.detail

import wooyoung.tom.simplespringboot.menu.MarketMenuEntity
import wooyoung.tom.simplespringboot.order.MarketOrderEntity
import javax.persistence.*

@Entity
@Table(name = "market_order_detail")
data class MarketOrderDetailEntity(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "order_id")
    val marketOrder: MarketOrderEntity,

    /**
     * @see menu [MarketMenuEntity] mapping
     */
    @OneToOne
    @JoinColumn(name = "menu_id")
    val menu: MarketMenuEntity,

    @Column(name = "menu_cnt")
    var menuCount: Int,

    @Column(name = "menu_status")
    var menuStatus: Boolean = true
)
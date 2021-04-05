package wooyoung.tom.simplespringboot.order.detail

import com.fasterxml.jackson.annotation.JsonIgnore
import wooyoung.tom.simplespringboot.menu.MarketMenuEntity
import javax.persistence.*

@Entity
@Table(name = "market_order_detail")
data class MarketOrderDetailEntity(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @JsonIgnore
    @Column(name = "order_id")
    val orderId: Long,

    /**
     * @see menu [MarketMenuEntity] mapping
     */
    @OneToOne
    @JoinColumn(name = "menu_id")
    val menu: MarketMenuEntity,

    @Column(name = "menu_cnt")
    val menuCount: Int
)
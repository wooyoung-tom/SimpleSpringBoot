package wooyoung.tom.simplespringboot.market.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "market_order_detail")
data class MarketOrderDetail(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore
    val orderDetailMarketOrder: MarketOrder,

    @OneToOne
    @JoinColumn(name = "menu_id")
    val orderDetailMarketMenu: MarketMenu,

    @Column(name = "menu_cnt")
    val menuCount: Int
)
package wooyoung.tom.simplespringboot.market.entity

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "market_order")
data class MarketOrder(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "user_id")
    val userId: Long,

    @Column(name = "order_date")
    val orderDate: LocalDate,

    @Column(name = "order_status")
    val orderStatus: String = "READY",
)
package wooyoung.tom.simplespringboot.market.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDate
import javax.persistence.*

// FIXME OrderStatus 칼럼 Enum Class 로 수정하는게 낫나?
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

    @OneToMany(mappedBy = "orderDetailMarketOrder")
    @JsonIgnore
    val orderDetailList: List<MarketOrderDetail> = ArrayList()
)
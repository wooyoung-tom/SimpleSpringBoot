package wooyoung.tom.simplespringboot.order

import com.fasterxml.jackson.annotation.JsonIgnore
import wooyoung.tom.simplespringboot.order.detail.MarketOrderDetailEntity
import wooyoung.tom.simplespringboot.restaurant.data.MarketRestaurantEntity
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "market_order")
data class MarketOrderEntity(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    /**
     * TODO user_id 연관관계 설정
     */
    @Column(name = "user_id")
    val userId: Long,

    @Column(name = "payment_id")
    var paymentId: Long? = null,

    /**
     * @see restaurant [MarketRestaurantEntity] mapping
     */
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "restaurant_id")
    val restaurant: MarketRestaurantEntity,

    @Column(name = "order_date")
    val orderDate: LocalDate,

    // status default = "Ready"
    @Column(name = "order_status")
    var orderStatus: String = "Ready",

    /**
     * @see orderDetailList [MarketOrderDetailEntity.marketOrder] mapping
     */
    @JsonIgnore
    @OneToMany(mappedBy = "marketOrder", fetch = FetchType.LAZY)
    val orderDetailList: List<MarketOrderDetailEntity> = ArrayList()
)

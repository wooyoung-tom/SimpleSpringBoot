package wooyoung.tom.simplespringboot.payment

import com.fasterxml.jackson.annotation.JsonIgnore
import wooyoung.tom.simplespringboot.order.MarketOrderEntity
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "market_payment")
data class MarketPaymentEntity(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "payment_method")
    val method: String,

    @Column(name = "payment_status")
    val status: String,

    @Column(name = "payment_date")
    val datetime: LocalDateTime,

    @JsonIgnore
    @OneToMany(mappedBy = "paymentId", fetch = FetchType.LAZY)
    val orderItems: List<MarketOrderEntity> = ArrayList()
)
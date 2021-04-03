package wooyoung.tom.simplespringboot.market.entity

import wooyoung.tom.simplespringboot.user.MarketUserEntity
import javax.persistence.*

@Entity
@Table(name = "market_review")
data class MarketReview(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val reviewMarketUser: MarketUserEntity,

    @Column(name = "content")
    val content: String,

    @Column(name = "rating")
    val rating: Float
)
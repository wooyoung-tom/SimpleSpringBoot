package wooyoung.tom.simplespringboot.review

import wooyoung.tom.simplespringboot.user.MarketUserEntity
import javax.persistence.*

@Entity
@Table(name = "market_review")
data class MarketReviewEntity(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    // 리뷰를 쓴 사용자 정보
    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: MarketUserEntity,

    @Column(name = "restaurant_id")
    val restaurantId: Long,

    @Column(name = "content")
    val content: String,

    @Column(name = "rating")
    val rating: Float
)
package wooyoung.tom.simplespringboot.review

import javax.persistence.*

@Entity
@Table(name = "market_review")
data class MarketReviewEntity(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    /**
     * TODO user_id, restaurant_id 연관관계 설정
     */
    @Column(name = "user_id")
    val userId: Long,

    @Column(name = "restaurant_id")
    val restaurantId: Long,

    @Column(name = "content")
    val content: String,

    @Column(name = "rating")
    val rating: Float
)
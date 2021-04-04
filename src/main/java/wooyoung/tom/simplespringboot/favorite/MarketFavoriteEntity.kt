package wooyoung.tom.simplespringboot.favorite

import javax.persistence.*

@Entity
@Table(name = "market_favorite")
data class MarketFavoriteEntity(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    /**
     * TODO user_id, restaurant_id 연관관계 설정
     */
    @Column(name = "user_id")
    val userId: Long,

    @Column(name = "restaurant_id")
    val restaurantId: Long
)

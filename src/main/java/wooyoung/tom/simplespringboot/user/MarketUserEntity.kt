package wooyoung.tom.simplespringboot.user

import com.fasterxml.jackson.annotation.JsonIgnore
import wooyoung.tom.simplespringboot.favorite.MarketFavoriteEntity
import wooyoung.tom.simplespringboot.order.MarketOrderEntity
import wooyoung.tom.simplespringboot.review.MarketReviewEntity
import javax.persistence.*

@Entity
@Table(name = "market_user")
data class MarketUserEntity(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "user_id")
    val userId: String,

    @JsonIgnore
    @Column(name = "password")
    val password: String,

    @Column(name = "username")
    val username: String,

    // order
    @JsonIgnore
    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    val orderList: List<MarketOrderEntity> = ArrayList(),

    // review
    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    val reviewList: List<MarketReviewEntity> = ArrayList(),

    // favorite
    @JsonIgnore
    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    val favoriteList: List<MarketFavoriteEntity> = ArrayList()
)
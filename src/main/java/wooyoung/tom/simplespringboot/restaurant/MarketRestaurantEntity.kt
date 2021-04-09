package wooyoung.tom.simplespringboot.restaurant

import com.fasterxml.jackson.annotation.JsonIgnore
import wooyoung.tom.simplespringboot.favorite.MarketFavoriteEntity
import wooyoung.tom.simplespringboot.menu.MarketMenuEntity
import wooyoung.tom.simplespringboot.review.MarketReviewEntity
import javax.persistence.*

@Entity
@Table(name = "market_restaurant")
data class MarketRestaurantEntity(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "name")
    val name: String,

    // Address Nullable
    @Column(name = "road_addr")
    val roadAddress: String? = null,

    @Column(name = "jibun_addr")
    val jibunAddress: String? = null,

    // phone_number Nullable
    @Column(name = "phone_number")
    val phoneNumber: String? = null,

    @Column(name = "longitude")
    val longitude: String,

    @Column(name = "latitude")
    val latitude: String,

    @Column(name = "category")
    val category: String,

    /**
     * @see menuList [MarketMenuEntity.restaurantId] mapping
     * @see favoriteList [MarketFavoriteEntity.restaurant] mapping
     * @see reviewList [MarketReviewEntity.restaurantId] mapping
     */
    @OneToMany(mappedBy = "restaurantId", fetch = FetchType.LAZY)
    val menuList: List<MarketMenuEntity> = ArrayList(),

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
    val favoriteList: List<MarketFavoriteEntity> = ArrayList(),

    @JsonIgnore
    @OneToMany(mappedBy = "restaurantId", fetch = FetchType.LAZY)
    val reviewList: List<MarketReviewEntity> = ArrayList()
)

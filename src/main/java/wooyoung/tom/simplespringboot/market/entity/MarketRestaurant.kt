package wooyoung.tom.simplespringboot.market.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

/**
 * @param roadAddress 도로명 주소 nullable
 * @param jibunAddress 지번 주소 nullable
 * @param phoneNumber 전화번호 nullable
 */
@Entity
@Table(name = "market_restaurant")
class MarketRestaurant(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "name")
    val restaurantName: String,

    @Column(name = "road_addr")
    val roadAddress: String? = null,

    @Column(name = "jibun_addr")
    val jibunAddress: String? = null,

    @Column(name = "phone_number")
    val phoneNumber: String? = null,

    @Column(name = "longitude")
    val longitude: String,

    @Column(name = "latitude")
    val latitude: String,

    @Column(name = "category")
    var category: String
) {

    @OneToMany(mappedBy = "menuRestaurant", fetch = FetchType.EAGER)
    val menuList: List<MarketMenu> = ArrayList()
}
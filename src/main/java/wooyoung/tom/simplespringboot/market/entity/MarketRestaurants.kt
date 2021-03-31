package wooyoung.tom.simplespringboot.market.entity

import javax.persistence.*

/**
 * @param road_address 도로명 주소 nullable
 * @param jibun_address 지번 주소 nullable
 * @param phone_number 전화번호 nullable
 */
@Entity
@Table(name = "market_restaurants")
class MarketRestaurants(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "name")
    val restaurant_name: String,

    @Column(name = "road_addr")
    val road_address: String? = null,

    @Column(name = "jibun_addr")
    val jibun_address: String? = null,

    @Column(name = "phone_number")
    val phone_number: String? = null,

    @Column(name = "latitude")
    val latitude: String,

    @Column(name = "longitude")
    val longitude: String,

    @Column(name = "category")
    var category: String
)
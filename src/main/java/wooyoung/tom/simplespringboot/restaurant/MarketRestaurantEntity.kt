package wooyoung.tom.simplespringboot.restaurant

import javax.persistence.*

/**
 * @param roadAddress 도로명 주소 nullable
 * @param jibunAddress 지번 주소 nullable
 * @param phoneNumber 전화번호 nullable
 */
@Entity
@Table(name = "market_restaurant")
data class MarketRestaurantEntity(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "name")
    val name: String,

    @Column(name = "road_addr")
    val roadAddress: String? = "",

    @Column(name = "jibun_addr")
    val jibunAddress: String? = "",

    @Column(name = "phone_number")
    val phoneNumber: String? = "",

    @Column(name = "longitude")
    val longitude: String,

    @Column(name = "latitude")
    val latitude: String,

    @Column(name = "category")
    val category: String

    /**
     * TODO review, favorite, order, menu 연관관계 설정
     *  restaurant_id 로 참조가능?
     */
)

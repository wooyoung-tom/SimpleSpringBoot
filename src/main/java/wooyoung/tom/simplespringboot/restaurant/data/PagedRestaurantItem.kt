package wooyoung.tom.simplespringboot.restaurant.data

import wooyoung.tom.simplespringboot.menu.MarketMenuEntity

data class PagedRestaurantItem(
    val restaurantId: Long,

    val restaurantName: String,

    val category: String,

    val roadAddress: String?,

    val jibunAddress: String?,

    val phoneNumber: String?,

    val longitude: String,

    val latitude: String,

    // 현재 위치와의 거리
    val distance: Int,

    // 현재 음식점 리뷰 개수
    val reviewCount: Int,

    // 현재 음식점 즐겨찾기 개수
    val favoriteCount: Int,

    // 현재 음식점의 메뉴 리스트
    val menuList: List<MarketMenuEntity>
)
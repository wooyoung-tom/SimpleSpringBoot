package wooyoung.tom.simplespringboot.restaurant.dto

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

    val menuList: List<MarketMenuEntity>
)
package wooyoung.tom.simplespringboot.restaurant.dto

data class PagedRestaurantItem(
    val restaurantId: Long,
    val restaurantName: String,
    val category: String,
    val roadAddress: String?,
    val jibunAddress: String?,
    val phoneNumber: String?,
    val longitude: String,
    val latitude: String
)
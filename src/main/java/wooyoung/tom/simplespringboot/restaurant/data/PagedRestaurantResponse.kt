package wooyoung.tom.simplespringboot.restaurant.data

import wooyoung.tom.simplespringboot.utils.PagedMetaData

data class PagedRestaurantResponse(
    val meta: PagedMetaData,
    val body: List<PagedRestaurantItem>
)
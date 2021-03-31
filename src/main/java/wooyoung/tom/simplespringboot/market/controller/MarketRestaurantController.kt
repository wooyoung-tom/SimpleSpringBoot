package wooyoung.tom.simplespringboot.market.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import wooyoung.tom.simplespringboot.market.dto.restaurant.MarketRestaurantCategorized
import wooyoung.tom.simplespringboot.market.service.MarketRestaurantService

@RestController
open class MarketRestaurantController(
    private val marketRestaurantService: MarketRestaurantService
) {

    @GetMapping("/market/restaurants")
    open fun findRestaurants(
        @RequestParam lat: String,
        @RequestParam lng: String,
        @RequestParam category: String
    ): MarketRestaurantCategorized {
        return marketRestaurantService.findRestaurantsByCategory(lat, lng, category)
    }
}
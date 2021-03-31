package wooyoung.tom.simplespringboot.market.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import wooyoung.tom.simplespringboot.market.dto.MarketRestaurantCategorized
import wooyoung.tom.simplespringboot.market.service.MarketRestaurantsService

@RestController
open class MarketRestaurantController(
    private val marketRestaurantsService: MarketRestaurantsService
) {

    @GetMapping("/market/restaurants")
    open fun findRestaurantsByCategory(
        @RequestParam category: String
    ): MarketRestaurantCategorized {
        return marketRestaurantsService.findRestaurantsByCategory(category)
    }
}
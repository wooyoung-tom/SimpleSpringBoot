package wooyoung.tom.simplespringboot.market.controller

import org.springframework.web.bind.annotation.*
import wooyoung.tom.simplespringboot.market.dto.favorite.CheckFavoriteResponse
import wooyoung.tom.simplespringboot.market.dto.favorite.DeleteFavoriteResponse
import wooyoung.tom.simplespringboot.market.dto.favorite.MarketFavoriteRequest
import wooyoung.tom.simplespringboot.market.dto.favorite.MarketFavoriteResponse
import wooyoung.tom.simplespringboot.market.dto.restaurant.MarketRestaurantCategorized
import wooyoung.tom.simplespringboot.market.service.MarketFavoriteService

@RestController
open class MarketFavoriteController(
    private val marketFavoriteService: MarketFavoriteService
) {

    @GetMapping("/market/favorites/{id}")
    open fun findFavoriteRestaurantsById(
        @PathVariable("id") userId: Long,
        @RequestParam("category") category: String,
        @RequestParam("lat") lat: String,
        @RequestParam("lng") lng: String
    ): MarketRestaurantCategorized {
        return marketFavoriteService.findFavoriteRestaurants(userId, category, lat, lng)
    }

    @PostMapping("/market/favorites")
    open fun saveFavoriteRestaurant(
        @RequestBody info: MarketFavoriteRequest
    ): MarketFavoriteResponse {
        return marketFavoriteService.saveFavorite(info.userId, info.restaurantId)
    }

    @GetMapping("/market/favorites")
    open fun checkFavorite(
        @RequestParam("user_id") userId: Long,
        @RequestParam("restaurant_id") restaurantId: Long
    ): CheckFavoriteResponse {
        return marketFavoriteService.checkFavorite(userId, restaurantId)
    }

    @DeleteMapping("/market/favorites")
    open fun deleteFavorite(
        @RequestParam("user_id") userId: Long,
        @RequestParam("restaurant_id") restaurantId: Long
    ): DeleteFavoriteResponse {
        return marketFavoriteService.deleteFavorite(userId, restaurantId)
    }
}
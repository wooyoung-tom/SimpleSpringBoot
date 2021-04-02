package wooyoung.tom.simplespringboot.market.controller

import org.springframework.web.bind.annotation.*
import wooyoung.tom.simplespringboot.market.dto.favorite.MarketFavoriteSaveRequest
import wooyoung.tom.simplespringboot.market.dto.restaurant.MarketRestaurantCategorized
import wooyoung.tom.simplespringboot.market.entity.MarketFavorite
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
        @RequestBody info: MarketFavoriteSaveRequest
    ): MarketFavorite {
        return marketFavoriteService.saveFavorite(info.userId, info.restaurantId)
    }

    @DeleteMapping("/market/favorites/{id}")
    open fun deleteFavoriteRestaurant(
        @PathVariable("id") favoriteId: Long
    ) {
        marketFavoriteService.deleteFavorite(favoriteId)
    }
}
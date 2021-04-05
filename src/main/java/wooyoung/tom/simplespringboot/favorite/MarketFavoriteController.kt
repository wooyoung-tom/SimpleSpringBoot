package wooyoung.tom.simplespringboot.favorite

import org.springframework.web.bind.annotation.*
import wooyoung.tom.simplespringboot.dto.CommonSimpleResponse
import wooyoung.tom.simplespringboot.favorite.dto.CheckFavoriteResponse
import wooyoung.tom.simplespringboot.favorite.dto.FavoriteRequest

@RestController
@RequestMapping("/favorites")
open class MarketFavoriteController(
    private val marketFavoriteService: MarketFavoriteService
) {

    @PostMapping
    open fun registerFavorite(
        @RequestBody info: FavoriteRequest
    ): CommonSimpleResponse {
        return marketFavoriteService.registerFavoriteRestaurant(info)
    }

    @GetMapping("/check/{id}")
    open fun checkFavorite(
        @PathVariable id: Long,
        @RequestParam restaurantId: Long
    ): CheckFavoriteResponse {
        return marketFavoriteService.checkMyFavoriteRestaurant(id, restaurantId)
    }

    @PostMapping("/delete")
    open fun deleteFavorite(
        @RequestBody info: FavoriteRequest
    ): FavoriteDeleteResponse {
        return marketFavoriteService.deleteFavorite(info)
    }
}
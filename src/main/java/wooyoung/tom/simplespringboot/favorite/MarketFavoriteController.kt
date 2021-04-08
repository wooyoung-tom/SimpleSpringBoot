package wooyoung.tom.simplespringboot.favorite

import org.springframework.web.bind.annotation.*
import wooyoung.tom.simplespringboot.utils.CommonSimpleResponse
import wooyoung.tom.simplespringboot.favorite.dto.FavoriteCheckResponse
import wooyoung.tom.simplespringboot.favorite.dto.FavoriteControlRequest

@RestController
@RequestMapping("/favorites")
open class MarketFavoriteController(
    private val marketFavoriteService: MarketFavoriteService
) {

    @PostMapping
    open fun registerFavorite(
        @RequestBody info: FavoriteControlRequest
    ): CommonSimpleResponse {
        return marketFavoriteService.registerFavoriteRestaurant(info)
    }

    @GetMapping("/check/{id}")
    open fun checkFavorite(
        @PathVariable id: Long,
        @RequestParam restaurantId: Long
    ): FavoriteCheckResponse {
        return marketFavoriteService.checkMyFavoriteRestaurant(id, restaurantId)
    }

    @PostMapping("/delete")
    open fun deleteFavorite(
        @RequestBody info: FavoriteControlRequest
    ): CommonSimpleResponse {
        return marketFavoriteService.deleteFavorite(info)
    }
}
package wooyoung.tom.simplespringboot.favorite

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import wooyoung.tom.simplespringboot.favorite.dto.FavoriteRegisterRequest
import wooyoung.tom.simplespringboot.favorite.dto.FavoriteRegisterResponse

@RestController
@RequestMapping("/favorites")
open class MarketFavoriteController(
    private val marketFavoriteService: MarketFavoriteService
) {

    @PostMapping
    open fun registerFavorite(
        @RequestBody info: FavoriteRegisterRequest
    ): FavoriteRegisterResponse {
        return marketFavoriteService.registerFavoriteRestaurant(info)
    }
}
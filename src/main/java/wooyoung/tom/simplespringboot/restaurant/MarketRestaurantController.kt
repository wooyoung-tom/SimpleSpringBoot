package wooyoung.tom.simplespringboot.restaurant

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/restaurants")
open class MarketRestaurantController(
    private val marketRestaurantService: MarketRestaurantService
) {

    // 카테고리별로 음식점 검색
    @GetMapping
    open fun findCategorizedRestaurants(
        @RequestParam category: String,
        pageable: Pageable
    ): Page<MarketRestaurantEntity> {
        return marketRestaurantService.findCategorizedRestaurants(category, pageable)
    }
}
package wooyoung.tom.simplespringboot.restaurant

import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import wooyoung.tom.simplespringboot.restaurant.dto.PagedRestaurantResponse

@RestController
@RequestMapping("/restaurants")
open class MarketRestaurantController(
    private val marketRestaurantService: MarketRestaurantService
) {

    // 카테고리별로 음식점 검색
    /**
     * @param category 검색할 카테고리
     * @param lat 현재 위치의 위도
     * @param lng 현재 위치의 경도
     */
    @GetMapping
    open fun findCategorizedRestaurants(
        @RequestParam category: String,
        @RequestParam lat: String,
        @RequestParam lng: String,
        @PageableDefault(size = 15, page = 0) pageable: Pageable
    ): PagedRestaurantResponse {
        return marketRestaurantService
            .findCategorizedRestaurants(category, lat, lng, pageable)
    }
}
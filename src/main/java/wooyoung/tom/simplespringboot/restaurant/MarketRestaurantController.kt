package wooyoung.tom.simplespringboot.restaurant

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.*
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
        @RequestParam(required = false) distance: Boolean,
        @RequestParam(required = false) review: Boolean,
        @RequestParam(required = false) literal: Boolean,
        @PageableDefault(size = 15, page = 0) pageable: Pageable
    ): PagedRestaurantResponse {
        val filteredPageable: Pageable = when {
            // TODO 거리순, 리뷰 많은 순에 대한 필터링 구현 (distance, review)
            literal -> {
                PageRequest.of(
                    pageable.pageNumber,
                    pageable.pageSize,
                    Sort.by("name").ascending()
                )
            }
            else -> pageable
        }

        return marketRestaurantService
            .findCategorizedRestaurants(category, lat, lng, filteredPageable)
    }

    // 즐겨찾기 해놓은 음식점 검색
    @GetMapping("/favorites/{id}")
    open fun findFavoriteRestaurants(
        @PathVariable id: Long,
        @RequestParam category: String,
        @RequestParam lat: String,
        @RequestParam lng: String,
        @PageableDefault(size = 15, page = 0) pageable: Pageable
    ): PagedRestaurantResponse {
        return marketRestaurantService.findFavoriteRestaurants(id, category, lat, lng, pageable)
    }
}
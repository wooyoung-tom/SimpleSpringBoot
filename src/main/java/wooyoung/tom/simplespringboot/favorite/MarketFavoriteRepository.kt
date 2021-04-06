package wooyoung.tom.simplespringboot.favorite

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface MarketFavoriteRepository : JpaRepository<MarketFavoriteEntity, Long> {

    // 음식점 ID 통해서 즐겨찾기 추가된 개수 가져온다.
    fun findAllByRestaurantIdAndStatus(
        restaurantId: Long, status: Boolean = true
    ): List<MarketFavoriteEntity>

    // 유저 ID 통해서 유저가 즐겨찾기 해놓은 음식점 리스트 가져오기
    fun findAllByUserIdAndStatus(
        userId: Long, status: Boolean = true, pageable: Pageable
    ): Page<MarketFavoriteEntity>

    // 유저 ID 와 레스토랑 ID 가지고 와서 즐겨찾기 찾는다.
    fun findMarketFavoriteEntityByUserIdAndRestaurantId(
        userId: Long, restaurantId: Long
    ): MarketFavoriteEntity?
}
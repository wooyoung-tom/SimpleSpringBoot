package wooyoung.tom.simplespringboot.favorite

import org.springframework.data.jpa.repository.JpaRepository

interface MarketFavoriteRepository: JpaRepository<MarketFavoriteEntity, Long> {

    // 음식점 ID 통해서 즐겨찾기 추가된 개수 가져온다.
    fun findAllByRestaurantId(restaurantId: Long): List<MarketFavoriteEntity>
}
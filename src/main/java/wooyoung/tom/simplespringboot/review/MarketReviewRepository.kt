package wooyoung.tom.simplespringboot.review

import org.springframework.data.jpa.repository.JpaRepository

interface MarketReviewRepository: JpaRepository<MarketReviewEntity, Long> {

    // 음식정 ID 통해서 리뷰 리스트 가져오기
    fun findAllByRestaurantId(restaurantId: Long): List<MarketReviewEntity>
}
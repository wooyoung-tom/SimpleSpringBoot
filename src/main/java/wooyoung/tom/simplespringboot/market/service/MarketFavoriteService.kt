package wooyoung.tom.simplespringboot.market.service

import org.springframework.stereotype.Service
import wooyoung.tom.simplespringboot.market.entity.MarketFavorite
import wooyoung.tom.simplespringboot.market.repository.MarketFavoriteRepository

@Service
open class MarketFavoriteService(
    private val marketFavoriteRepository: MarketFavoriteRepository
) {

    // 즐겨찾기 등록
    open fun saveFavorite(userId: Long, restaurantId: Long): MarketFavorite {
        val newFavoriteItem = MarketFavorite(
            userId = userId,
            restaurantId = restaurantId
        )

        return marketFavoriteRepository.save(newFavoriteItem)
    }

    // 즐겨찾기 삭제
    open fun deleteFavorite(favoriteId: Long) {
        marketFavoriteRepository.deleteById(favoriteId)
    }
}
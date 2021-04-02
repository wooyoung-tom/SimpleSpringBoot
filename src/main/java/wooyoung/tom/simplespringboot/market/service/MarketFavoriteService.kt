package wooyoung.tom.simplespringboot.market.service

import org.springframework.stereotype.Service
import wooyoung.tom.simplespringboot.market.dto.restaurant.CategorizedRestaurantItem
import wooyoung.tom.simplespringboot.market.dto.restaurant.MarketRestaurantCategorized
import wooyoung.tom.simplespringboot.market.entity.MarketFavorite
import wooyoung.tom.simplespringboot.market.repository.MarketFavoriteRepository
import wooyoung.tom.simplespringboot.market.repository.MarketRestaurantRepository
import wooyoung.tom.simplespringboot.utils.getDistance

@Service
open class MarketFavoriteService(
    private val marketFavoriteRepository: MarketFavoriteRepository,
    private val marketRestaurantRepository: MarketRestaurantRepository
) {

    // 즐겨찾기 등록
    open fun saveFavorite(userId: Long, restaurantId: Long): MarketFavorite {
        val foundRestaurant = marketRestaurantRepository.findById(restaurantId)
        val newFavoriteItem = MarketFavorite(
            userId = userId,
            favoriteMarketRestaurant = foundRestaurant.get()
        )

        return marketFavoriteRepository.save(newFavoriteItem)
    }

    // 즐겨찾기 삭제
    open fun deleteFavorite(favoriteId: Long) {
        marketFavoriteRepository.deleteById(favoriteId)
    }

    open fun findFavoriteRestaurants(
        userId: Long, category: String, lat: String, lng: String
    ): MarketRestaurantCategorized {
        // 즐겨찾기 해놓은 아이템을 가져오기
        val favorite = marketFavoriteRepository.findMarketFavoritesByUserId(userId)

        // 즐겨찾기 해놓은 아이템 중에 카테고리 체크하기
        val categorizedFavorite = favorite.filter { marketFavorite ->
            marketFavorite.favoriteMarketRestaurant.category == category
        }

        // 카테고리 맞춘 리스트를 매핑
        val convertedList = categorizedFavorite.map { marketFavorite ->
            val distanceCalResult = getDistance(
                lat1 = marketFavorite.favoriteMarketRestaurant.latitude.toDouble(),
                lat2 = lat.toDouble(),
                lng1 = marketFavorite.favoriteMarketRestaurant.longitude.toDouble(),
                lng2 = lng.toDouble()
            )

            CategorizedRestaurantItem(
                restaurant = marketFavorite.favoriteMarketRestaurant,
                distance = distanceCalResult,
                review = marketFavorite.favoriteMarketRestaurant.reviewList.size,
                favorite = marketFavorite.favoriteMarketRestaurant.favoriteList.size
            )
        }

        return MarketRestaurantCategorized(
            category = category,
            body = convertedList
        )
    }
}
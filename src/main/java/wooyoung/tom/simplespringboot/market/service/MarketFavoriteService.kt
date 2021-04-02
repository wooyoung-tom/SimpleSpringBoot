package wooyoung.tom.simplespringboot.market.service

import org.springframework.stereotype.Service
import wooyoung.tom.simplespringboot.market.dto.favorite.CheckFavoriteResponse
import wooyoung.tom.simplespringboot.market.dto.favorite.DeleteFavoriteResponse
import wooyoung.tom.simplespringboot.market.dto.favorite.MarketFavoriteResponse
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
    open fun saveFavorite(userId: Long, restaurantId: Long): MarketFavoriteResponse {
        val foundRestaurant = marketRestaurantRepository.findById(restaurantId)
        val newFavoriteItem = MarketFavorite(
            userId = userId,
            favoriteMarketRestaurant = foundRestaurant.get()
        )

        marketFavoriteRepository.save(newFavoriteItem)

        return MarketFavoriteResponse("SUCCESS")
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

    // 내 아이디와 레스토랑 아이디를 가지고 내가 즐겨찾기 해놓은 음식점인지 확인
    open fun checkFavorite(userId: Long, restaurantId: Long): CheckFavoriteResponse {
        // 먼저 레스토랑 객체를 찾아와야한다.
        val restaurant = marketRestaurantRepository.findById(restaurantId)

        return if (restaurant.isPresent) {
            val favorite = marketFavoriteRepository
                .findMarketFavoriteByUserIdAndFavoriteMarketRestaurant(userId, restaurant.get())

            if (favorite == null) CheckFavoriteResponse(checkFavorite = false)
            else CheckFavoriteResponse(
                favoriteId = favorite.id,
                checkFavorite = true
            )
        } else CheckFavoriteResponse(checkFavorite = false)
    }

    open fun deleteFavorite(userId: Long, restaurantId: Long): DeleteFavoriteResponse {
        // 먼저 레스토랑 객체를 찾아와야한다.
        val restaurant = marketRestaurantRepository.findById(restaurantId)

        return if (restaurant.isPresent) {
            val favorite = marketFavoriteRepository
                .findMarketFavoriteByUserIdAndFavoriteMarketRestaurant(userId, restaurant.get())

            if (favorite == null) DeleteFavoriteResponse("FAILED")
            else {
                marketFavoriteRepository.deleteById(favorite.id!!)
                DeleteFavoriteResponse("SUCCESS")
            }
        } else {
            DeleteFavoriteResponse("FAILED")
        }
    }
}
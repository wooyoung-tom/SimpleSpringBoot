package wooyoung.tom.simplespringboot.favorite

import org.springframework.stereotype.Service
import wooyoung.tom.simplespringboot.favorite.dto.FavoriteRegisterRequest
import wooyoung.tom.simplespringboot.favorite.dto.FavoriteRegisterResponse
import wooyoung.tom.simplespringboot.restaurant.MarketRestaurantRepository

@Service
open class MarketFavoriteService(
    private val marketRestaurantRepository: MarketRestaurantRepository,
    private val marketFavoriteRepository: MarketFavoriteRepository
) {

    // 즐겨찾기 등록
    open fun registerFavoriteRestaurant(
        favoriteRegisterRequest: FavoriteRegisterRequest
    ): FavoriteRegisterResponse {
        // 음식점 먼저 찾는다.
        val restaurant = marketRestaurantRepository
            .findById(favoriteRegisterRequest.restaurantId)

        // 음식점 없으면 return
        if (!restaurant.isPresent) {
            return FavoriteRegisterResponse(
                code = "Failed",
                message = "음식점을 찾지 못했습니다."
            )
        }

        // 즐겨찾기 리스트에 있는지 먼저 확인한다.
        val favorite = marketFavoriteRepository
            .findMarketFavoriteEntityByUserIdAndRestaurant(
                favoriteRegisterRequest.userId, restaurant.get()
            )

        // 없으면 만든다.
        if (favorite == null) {
            val newFavorite = MarketFavoriteEntity(
                userId = favoriteRegisterRequest.userId,
                restaurant = restaurant.get()
            )

            try {
                marketFavoriteRepository.save(newFavorite)
            } catch (npe: NullPointerException) {
                return FavoriteRegisterResponse(
                    code = "Failed",
                    message = "즐겨찾기를 생성하는 데 실패했습니다."
                )
            }
        } else {
            // 있으면 status true update
            favorite.status = true
        }

        return FavoriteRegisterResponse(
            code = "Success",
            message = "즐겨찾기 등록에 성공하였습니다."
        )
    }
}
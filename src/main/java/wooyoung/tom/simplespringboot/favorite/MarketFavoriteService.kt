package wooyoung.tom.simplespringboot.favorite

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.dto.CommonSimpleResponse
import wooyoung.tom.simplespringboot.favorite.dto.CheckFavoriteResponse
import wooyoung.tom.simplespringboot.favorite.dto.FavoriteRequest
import wooyoung.tom.simplespringboot.restaurant.MarketRestaurantRepository

@Service
open class MarketFavoriteService(
    private val marketRestaurantRepository: MarketRestaurantRepository,
    private val marketFavoriteRepository: MarketFavoriteRepository
) {

    // 내가 즐겨찾기 해놓은 식당인지 판별
    open fun checkMyFavoriteRestaurant(userId: Long, restaurantId: Long): CheckFavoriteResponse {
        // 음식점 먼저 찾는다.
        val restaurant = marketRestaurantRepository.findById(restaurantId)

        // 음식점 없으면 return
        if (!restaurant.isPresent) {
            return CheckFavoriteResponse(
                code = "Failed",
                message = "음식점을 찾지 못했습니다."
            )
        }

        val result = marketFavoriteRepository
            .findMarketFavoriteEntityByUserIdAndRestaurant(userId, restaurant.get())

        return if (result == null) {
            CheckFavoriteResponse(
                code = "Success",
                message = "즐겨찾기가 되어있지 않습니다.",
                favorite = false
            )
        } else {
            CheckFavoriteResponse(
                code = "Success",
                message = "즐겨찾기 등록된 음식점입니다.",
                favorite = true
            )
        }
    }

    // 즐겨찾기 등록
    @Transactional
    open fun registerFavoriteRestaurant(info: FavoriteRequest): CommonSimpleResponse {
        // 음식점 먼저 찾는다.
        val restaurant = marketRestaurantRepository.findById(info.restaurantId)

        // 음식점 없으면 return
        if (!restaurant.isPresent) {
            return CommonSimpleResponse(
                code = "Failed",
                message = "음식점을 찾지 못했습니다."
            )
        }

        // 즐겨찾기 리스트에 있는지 먼저 확인한다.
        val favorite = marketFavoriteRepository
            .findMarketFavoriteEntityByUserIdAndRestaurant(info.userId, restaurant.get())

        // 없으면 만든다.
        if (favorite == null) {
            val newFavorite = MarketFavoriteEntity(
                userId = info.userId,
                restaurant = restaurant.get()
            )

            try {
                marketFavoriteRepository.save(newFavorite)
            } catch (npe: NullPointerException) {
                return CommonSimpleResponse(
                    code = "Failed",
                    message = "즐겨찾기를 생성하는 데 실패했습니다."
                )
            }
        } else {
            // 있으면 status true update
            favorite.status = true
        }

        return CommonSimpleResponse(
            code = "Success",
            message = "즐겨찾기 등록에 성공하였습니다."
        )
    }

    // 즐겨찾기 지우기
    @Transactional
    open fun deleteFavorite(info: FavoriteRequest): CommonSimpleResponse {
        // 음식점 먼저 찾는다.
        val restaurant = marketRestaurantRepository.findById(info.restaurantId)

        // 음식점 없으면 return
        if (!restaurant.isPresent) {
            return CommonSimpleResponse(
                code = "Failed",
                message = "음식점을 찾지 못했습니다."
            )
        }

        val foundResult = marketFavoriteRepository
            .findMarketFavoriteEntityByUserIdAndRestaurant(info.userId, restaurant.get())

        if (foundResult == null) {
            return CommonSimpleResponse(
                code = "Failed",
                message = "즐겨찾기 항목을 찾는데 실패했습니다."
            )
        } else {
            if (!foundResult.status) {
                return CommonSimpleResponse(
                    code = "Failed",
                    message = "이미 삭제된 즐겨찾기 항목입니다."
                )
            }
            foundResult.status = false

            try {
                marketFavoriteRepository.save(foundResult)
            } catch (npe: NullPointerException) {
                return CommonSimpleResponse(
                    code = "Failed",
                    message = "즐겨찾기 상태를 변경하는데 실패했습니다."
                )
            }
        }

        return CommonSimpleResponse(
            code = "Success",
            message = "즐겨찾기 상태를 변경하였습니다."
        )
    }
}
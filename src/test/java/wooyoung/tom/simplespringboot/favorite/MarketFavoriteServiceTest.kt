package wooyoung.tom.simplespringboot.favorite

import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.restaurant.MarketRestaurantRepository

@RunWith(SpringRunner::class)
@SpringBootTest
@Transactional
internal open class MarketFavoriteServiceTest {

    @Autowired
    private lateinit var marketFavoriteRepository: MarketFavoriteRepository

    @Autowired
    private lateinit var marketRestaurantRepository: MarketRestaurantRepository

    @Test
    fun `내가 설정해놓은 즐겨찾기 음식점인지 확인`() {
        val givenUserId: Long = 13
        val givenRestaurantId: Long = 5

        // 음식점 먼저 찾는다.
        val restaurant = marketRestaurantRepository.findById(givenRestaurantId)

        Assertions.assertThat(restaurant.isPresent).isTrue

        // 즐겨찾기 repository 에서 찾는다.
        val result = marketFavoriteRepository
            .findMarketFavoriteEntityByUserIdAndRestaurant(givenUserId, restaurant.get())

        Assertions.assertThat(result).isNotNull
    }

    @Test
    fun `즐겨찾기 음식점 등록`() {
        val givenUserId: Long = 13
        val givenRestaurantId: Long = 5

        // restaurant item 먼저 가져온다.
        val restaurant = marketRestaurantRepository.findById(givenRestaurantId)

        Assertions.assertThat(restaurant.isPresent).isTrue

        val favorite = marketFavoriteRepository
            .findMarketFavoriteEntityByUserIdAndRestaurant(givenUserId, restaurant.get())

        Assertions.assertThat(favorite).isNull()

        val newFavorite = MarketFavoriteEntity(
            userId = givenUserId,
            restaurant = restaurant.get()
        )

        val saveResult = marketFavoriteRepository.save(newFavorite)

        Assertions.assertThat(saveResult.id).isEqualTo(newFavorite.id)
    }

    @Test
    fun `즐겨찾기 음식점 삭제`() {
        val givenUserId: Long = 13
        val givenRestaurantId: Long = 5

        // restaurant item 먼저 가져온다.
        val restaurant = marketRestaurantRepository.findById(givenRestaurantId)

        Assertions.assertThat(restaurant.isPresent).isTrue

        val favorite = marketFavoriteRepository
            .findMarketFavoriteEntityByUserIdAndRestaurant(givenUserId, restaurant.get())

        Assertions.assertThat(favorite).isNotNull
        Assertions.assertThat(favorite?.status).isNotNull.isTrue

        favorite!!.status = false
        val edit = marketFavoriteRepository.save(favorite)

        Assertions.assertThat(edit.status).isFalse
    }
}
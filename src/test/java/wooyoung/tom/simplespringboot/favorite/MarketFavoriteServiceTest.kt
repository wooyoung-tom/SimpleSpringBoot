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
}
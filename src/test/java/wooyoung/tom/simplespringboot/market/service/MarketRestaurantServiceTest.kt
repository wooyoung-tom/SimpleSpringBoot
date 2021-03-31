package wooyoung.tom.simplespringboot.market.service

import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.market.repository.MarketRestaurantRepository
import wooyoung.tom.simplespringboot.market.repository.MarketReviewRepository

@SpringBootTest
@RunWith(SpringRunner::class)
@Transactional
internal open class MarketRestaurantServiceTest {

    @Autowired
    private lateinit var marketRestaurantRepository: MarketRestaurantRepository

    @Test
    fun `카테고리별 레스토랑 가져오기`() {
        val category = "한식"
        val findResult = marketRestaurantRepository.findMarketRestaurantsByCategory(category)

        println(findResult.size)

        Assertions.assertThat(findResult.isEmpty()).isEqualTo(false)
    }

    @Test
    @Transactional
    open fun `ID를 통해 레스토랑 상세 정보 가져오기`() {
        val restaurantId = 1L

        val foundRestaurantResult = marketRestaurantRepository.findById(restaurantId)

        Assertions.assertThat(foundRestaurantResult.isPresent).isEqualTo(true)

        val foundRestaurant = foundRestaurantResult.get()

        // 메뉴는 음식점당 세 개
        Assertions.assertThat(foundRestaurant.menuList.size).isEqualTo(3)
        // 현재는 음식점에 리뷰가 없어야 한다.
        Assertions.assertThat(foundRestaurant.reviewList.isEmpty()).isEqualTo(true)
        // 현재는 음식점 즐겨찾기 개수가 없어야 한다.
        Assertions.assertThat(foundRestaurant.favoriteList.isEmpty()).isEqualTo(true)
    }
}
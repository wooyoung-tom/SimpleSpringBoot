package wooyoung.tom.simplespringboot.market.service

import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import wooyoung.tom.simplespringboot.market.repository.MarketRestaurantRepository

@SpringBootTest
@RunWith(SpringRunner::class)
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
}
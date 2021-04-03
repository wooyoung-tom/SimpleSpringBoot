package wooyoung.tom.simplespringboot.restaurant

import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional

@RunWith(SpringRunner::class)
@SpringBootTest
@Transactional
internal open class MarketRestaurantServiceTest {

    @Autowired
    private lateinit var marketRestaurantRepository: MarketRestaurantRepository

    @Test
    fun `카테고리별 음식점 탐색 (pagination)`() {

    }
}
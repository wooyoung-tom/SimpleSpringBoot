package wooyoung.tom.simplespringboot.market.service

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.market.entity.MarketMenu
import wooyoung.tom.simplespringboot.market.repository.MarketMenuRepository
import wooyoung.tom.simplespringboot.market.repository.MarketRestaurantRepository
import kotlin.random.Random

@SpringBootTest
@RunWith(SpringRunner::class)
@Transactional
internal open class MarketMenuServiceTest {

    @Autowired
    private lateinit var marketMenuRepository: MarketMenuRepository

    @Autowired
    private lateinit var marketRestaurantRepository: MarketRestaurantRepository

    @Test
    fun `레스토랑 메뉴 가져오기`() {

    }
}
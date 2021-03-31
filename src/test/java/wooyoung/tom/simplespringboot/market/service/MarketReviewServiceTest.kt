package wooyoung.tom.simplespringboot.market.service

import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.market.repository.MarketReviewRepository

@SpringBootTest
@RunWith(SpringRunner::class)
@Transactional
internal open class MarketReviewServiceTest {

    @Autowired
    private lateinit var marketReviewRepository: MarketReviewRepository

}
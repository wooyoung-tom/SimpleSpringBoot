package wooyoung.tom.simplespringboot.order

import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@RunWith(SpringRunner::class)
@SpringBootTest
@Transactional
internal open class MarketOrderServiceTest {

    @Autowired
    private lateinit var marketOrderRepository: MarketOrderRepository

    @Test
    fun `오더 등록`() {
        val givenUserId: Long = 13
        val givenRestaurantId: Long = 5

        // 먼저 전체 오더 아이템 하나 생성
        val newOrder = MarketOrderEntity(
            userId = givenUserId,
            restaurantId = givenRestaurantId,
            orderDate = LocalDate.now(),
        )

        val saveResult = marketOrderRepository.save(newOrder)

        // 저장한 아이템이 id 같아야 한다.
        Assertions.assertThat(saveResult.id).isEqualTo(newOrder.id)
    }

    @Test
    fun `오더 조회`() {
        val givenUserId: Long = 13

        val orders = marketOrderRepository.findAllByUserId(givenUserId)

        // 아직 오더 등록된 것이 없다.
        Assertions.assertThat(orders).isEmpty()
    }
}
package wooyoung.tom.simplespringboot.payment

import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.order.MarketOrderRepository

@RunWith(SpringRunner::class)
@SpringBootTest
@Transactional
internal open class MarketPaymentServiceTest {

    @Autowired
    private lateinit var marketPaymentRepository: MarketPaymentRepository

    @Autowired
    private lateinit var marketOrderRepository: MarketOrderRepository

    @Test
    fun `유저가 가지고있는 가장 오래된 나중결제 아이템 가져오기`() {
        val givenUserId = 12L

        val orders = marketOrderRepository
            .findAllByUserIdAndOrderStatus(givenUserId, "Later")

        Assertions.assertThat(orders).isNotEmpty

        val paymentIds = orders.groupBy { it.paymentId ?: 0 }.keys.toList()

        val paymentItems = marketPaymentRepository.findAllByIdInOrderByDatetimeAsc(paymentIds)

        Assertions.assertThat(paymentItems).isNotEmpty
    }
}
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
import java.time.LocalDateTime

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

    @Test
    fun `주문 결제 취소`() {
        val givenPaymentId = 24L

        // 취소된 주문을 하나 만든다.
        val canceledPayment = MarketPaymentEntity(
            method = "취소된 결제",
            status = "Canceled",
            datetime = LocalDateTime.now()
        )

        // 결제 저장
        val saveResult = marketPaymentRepository.save(canceledPayment)

        Assertions.assertThat(saveResult.id).isEqualTo(canceledPayment.id)

        // 주어진 결제와 연결된 오더들 취소된 주문 id 로 연결 후 상태 변경
        val orders = marketOrderRepository.findAllByPaymentId(givenPaymentId)

        Assertions.assertThat(orders).isNotEmpty

        // 준비 상태로 수정한다.
        orders.forEach {
            it.paymentId = canceledPayment.id
            it.orderStatus = "Ready"
        }

        marketOrderRepository.saveAll(orders)
    }

    @Test
    fun `user id로 오더 조회 후 결제 정보 가져오기`() {
        val givenUserId: Long = 12

        val orders = marketOrderRepository.findAllByUserId(givenUserId)

        Assertions.assertThat(orders).isNotEmpty

        // 결제 id 가져온다.
        val paymentIds = orders.filter { it.paymentId != null }
            .groupBy { it.paymentId!! }.keys.toList()

        Assertions.assertThat(paymentIds).isNotEmpty

        val payments = marketPaymentRepository.findAllByIdInOrderByDatetimeAsc(paymentIds)

        Assertions.assertThat(payments).isNotEmpty
    }
}
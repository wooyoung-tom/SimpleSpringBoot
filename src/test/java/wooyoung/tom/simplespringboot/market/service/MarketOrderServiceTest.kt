package wooyoung.tom.simplespringboot.market.service

import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.market.entity.MarketOrder
import wooyoung.tom.simplespringboot.market.entity.MarketOrderDetail
import wooyoung.tom.simplespringboot.market.repository.MarketMenuRepository
import wooyoung.tom.simplespringboot.market.repository.MarketOrderDetailRepository
import wooyoung.tom.simplespringboot.market.repository.MarketOrderRepository
import wooyoung.tom.simplespringboot.market.repository.MarketUserRepository
import java.time.LocalDate

@SpringBootTest
@RunWith(SpringRunner::class)
internal open class MarketOrderServiceTest {

    @Autowired
    private lateinit var marketUserRepository: MarketUserRepository

    @Autowired
    private lateinit var marketOrderRepository: MarketOrderRepository

    @Autowired
    private lateinit var marketOrderDetailRepository: MarketOrderDetailRepository

    @Autowired
    private lateinit var marketMenuRepository: MarketMenuRepository

    @Test
    fun `전체 오더 하나 추가 (Detail 제외)`() {
        val foundUser = marketUserRepository.findMarketUserByName("test")

        Assertions.assertThat(foundUser == null).isEqualTo(false)

        val foundUserId = foundUser?.id ?: 0

        // 전체적인 오더를 먼저 만들어야 한다.
        val newOrder = MarketOrder(
            userId = foundUserId,
            orderDate = LocalDate.now()
        )

        val saveOrderResult = marketOrderRepository.save(newOrder)

        Assertions.assertThat(saveOrderResult.orderStatus).isEqualTo("READY")
    }

    @Test
    fun `전체 오더 추가 (Detail 추가)`() {
        // 테스트용 유저 하나 찾는다.
        val foundUser = marketUserRepository.findMarketUserByName("test")

        Assertions.assertThat(foundUser == null).isEqualTo(false)

        val foundUserId = foundUser?.id ?: 0

        // 전체적인 오더 하나 먼저 생성
        val newOrder = MarketOrder(
            userId = foundUserId,
            orderDate = LocalDate.now()
        )

        // 오더 저장
        val saveOrderResult = marketOrderRepository.save(newOrder)

        // 저장된 오더가 있으면 id not null
        Assertions.assertThat(saveOrderResult.id == null).isEqualTo(false)

        // 메뉴 가져오기
        val menu = marketMenuRepository.findById(15026L)

        // 오더 상세 생성 (토마토 파스타 세개)
        val newOrderDetail = MarketOrderDetail(
            orderDetailMarketOrder = saveOrderResult,
            orderDetailMarketMenu = menu.get(),
            menuCount = 2
        )

        val saveOrderDetailResult = marketOrderDetailRepository.save(newOrderDetail)

        Assertions.assertThat(saveOrderDetailResult.id == null).isEqualTo(false)
    }

    @Test
    fun `오더 상태 READY (장바구니) 리스트 가져오기`() {
        val foundUser = marketUserRepository.findMarketUserByName("test")

        Assertions.assertThat(foundUser == null).isEqualTo(false)

        val foundUserId = foundUser?.id ?: 0

        val foundUserOrders = marketOrderRepository
            .findMarketOrdersByUserIdAndOrderStatus(foundUserId, "READY")

        Assertions.assertThat(foundUserOrders.isEmpty()).isEqualTo(false)
    }
}
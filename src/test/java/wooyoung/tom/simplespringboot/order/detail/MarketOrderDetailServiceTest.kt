package wooyoung.tom.simplespringboot.order.detail

import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.menu.MarketMenuRepository
import wooyoung.tom.simplespringboot.order.MarketOrderRepository
import wooyoung.tom.simplespringboot.order.dto.save.MarketOrderSaveRequestItem

@RunWith(SpringRunner::class)
@SpringBootTest
@Transactional
internal open class MarketOrderDetailServiceTest {

    @Autowired
    private lateinit var marketOrderRepository: MarketOrderRepository

    @Autowired
    private lateinit var marketOrderDetailRepository: MarketOrderDetailRepository

    @Autowired
    private lateinit var marketMenuRepository: MarketMenuRepository

    @Test
    fun `오더 id 통해 디테일 아이템 가져오기`() {
        val givenOrderId: Long = 27

        val order = marketOrderDetailRepository.findAllByMarketOrderId(givenOrderId)

        println(order.size)

        Assertions.assertThat(order).isNotEmpty
    }

    @Test
    fun `오더 디테일 아이템 상태 수정`() {
        val givenOrderId: Long = 27
        val givenMenuList = listOf(
            MarketOrderSaveRequestItem(menuId = 15034, menuCount = 3),
            MarketOrderSaveRequestItem(menuId = 15035, menuCount = 1)
        )

        // 오더 item
        val order = marketOrderRepository.findById(givenOrderId)

        // 오더 id, status 가지고 detail list 가져온다.
        val orderDetails = marketOrderDetailRepository
            .findAllByMarketOrderIdAndMenuStatus(givenOrderId)

        orderDetails.forEach { original ->
            original.menuStatus = false

            // 상태 변경 후 update
            marketOrderDetailRepository.save(original)
        }

        givenMenuList.forEach { request ->
            val menu = marketMenuRepository.findById(request.menuId)
            val newOrderDetail = MarketOrderDetailEntity(
                marketOrder = order.get(),
                menu = menu.get(),
                menuCount = request.menuCount
            )
            marketOrderDetailRepository.save(newOrderDetail)
        }
    }
}
package wooyoung.tom.simplespringboot.order.detail

import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.order.dto.MarketOrderDetailEditRequest
import wooyoung.tom.simplespringboot.order.dto.MarketOrderSaveRequest
import wooyoung.tom.simplespringboot.order.dto.MarketOrderSaveRequestItem

@RunWith(SpringRunner::class)
@SpringBootTest
@Transactional
internal open class MarketOrderDetailServiceTest {

    @Autowired
    private lateinit var marketOrderDetailRepository: MarketOrderDetailRepository

    @Test
    fun `오더 id 통해 디테일 아이템 가져오기`() {
        val givenOrderId: Long = 27

        val order = marketOrderDetailRepository.findAllByMarketOrderId(givenOrderId)

        println(order.size)

        Assertions.assertThat(order).isNotEmpty
    }

    @Test
    fun `오더 디테일 아이템 수정`() {
        val givenOrderId: Long = 27
        val givenMenuList = listOf(
            MarketOrderSaveRequestItem(menuId = 15034, menuCount = 3),
            MarketOrderSaveRequestItem(menuId = 15035, menuCount = 1)
        )

        givenMenuList.forEach {
            // 오더 아이디와 메뉴 아이디로 디테일 아이템 가져온다.
            val originalOrderDetail = marketOrderDetailRepository
                .findAllByMarketOrderIdAndMenuId(givenOrderId, it.menuId)

            Assertions.assertThat(originalOrderDetail).isNotNull


        }
    }
}
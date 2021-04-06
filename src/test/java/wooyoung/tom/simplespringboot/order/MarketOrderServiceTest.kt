package wooyoung.tom.simplespringboot.order

import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.menu.MarketMenuRepository
import wooyoung.tom.simplespringboot.order.detail.MarketOrderDetailEntity
import wooyoung.tom.simplespringboot.order.detail.MarketOrderDetailRepository
import wooyoung.tom.simplespringboot.restaurant.MarketRestaurantRepository
import java.time.LocalDate

@RunWith(SpringRunner::class)
@SpringBootTest
@Transactional
internal open class MarketOrderServiceTest {

    @Autowired
    private lateinit var marketOrderRepository: MarketOrderRepository

    @Autowired
    private lateinit var marketMenuRepository: MarketMenuRepository

    @Autowired
    private lateinit var marketOrderDetailRepository: MarketOrderDetailRepository

    @Autowired
    private lateinit var marketRestaurantRepository: MarketRestaurantRepository

    @Test
    fun `오더 등록`() {
        val givenUserId: Long = 13
        val givenRestaurantId: Long = 5

        val givenRestaurant = marketRestaurantRepository.findById(givenRestaurantId)

        Assertions.assertThat(givenRestaurant.isPresent).isTrue

        // 먼저 전체 오더 아이템 하나 생성
        val newOrder = MarketOrderEntity(
            userId = givenUserId,
            restaurant = givenRestaurant.get(),
            orderDate = LocalDate.now(),
        )

        val saveResult = marketOrderRepository.save(newOrder)

        // 저장한 아이템이 id 같아야 한다.
        Assertions.assertThat(saveResult.id).isEqualTo(newOrder.id)

        val givenMenuList = listOf(
            marketMenuRepository.findById(15034L),
            marketMenuRepository.findById(15035L),
            marketMenuRepository.findById(15036L)
        )

        // 메뉴 리스트 순회하면서 order detail save
        givenMenuList.forEach {
            val menu = it.get()
            val givenOrderDetail = MarketOrderDetailEntity(
                marketOrder = saveResult,
                menu = menu,
                menuCount = 3
            )

            val detailSaveResult = marketOrderDetailRepository.save(givenOrderDetail)

            Assertions.assertThat(detailSaveResult.id).isEqualTo(givenOrderDetail.id)
        }
    }

    @Test
    fun `오더 조회`() {
        val givenUserId: Long = 13

        val orders = marketOrderRepository.findAllByUserIdAndOrderStatus(givenUserId)

        // 오더 조회 가능
        Assertions.assertThat(orders).isNotEmpty
    }
}
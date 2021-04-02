package wooyoung.tom.simplespringboot.market.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.market.dto.order.BasketItem
import wooyoung.tom.simplespringboot.market.dto.order.MarketOrderSaveItem
import wooyoung.tom.simplespringboot.market.dto.order.MarketOrderSaveResponse
import wooyoung.tom.simplespringboot.market.entity.MarketOrder
import wooyoung.tom.simplespringboot.market.entity.MarketOrderDetail
import wooyoung.tom.simplespringboot.market.repository.MarketMenuRepository
import wooyoung.tom.simplespringboot.market.repository.MarketOrderDetailRepository
import wooyoung.tom.simplespringboot.market.repository.MarketOrderRepository
import java.time.LocalDate

@Service
open class MarketOrderService(
    private val marketMenuRepository: MarketMenuRepository,
    private val marketOrderRepository: MarketOrderRepository,
    private val marketOrderDetailRepository: MarketOrderDetailRepository
) {

    // 대기중인 오더 리스트 가져온다.
    open fun findReadyOrderListByUserId(userId: Long): List<BasketItem> {
        val foundReadyOrderList = marketOrderRepository
            .findMarketOrdersByUserIdAndOrderStatus(userId, "READY")

        return foundReadyOrderList.map { marketOrder ->
            BasketItem(
                restaurantName = marketOrder.orderDetailList[0]
                    .orderDetailMarketMenu.menuMarketRestaurant.restaurantName,
                menuList = marketOrder.orderDetailList,
                totalPrice = marketOrder.orderDetailList.sumOf {
                    (it.orderDetailMarketMenu.price * it.menuCount)
                }
            )
        }
    }

    // FIXME 코드 너무 이상함 갈아엎어야 함
    @Transactional
    open fun saveOrder(userId: Long, menuList: List<MarketOrderSaveItem>): MarketOrderSaveResponse {
        // 새로운 전체오더 만들어서 하나 저장해놓는다.
        val newOrder = MarketOrder(
            userId = userId,
            orderDate = LocalDate.now()
        )

        val saveOrderResult = marketOrderRepository.save(newOrder)

        val convertedList = menuList.map { marketOrderSaveItem ->
            // 가지고 있는 메뉴 ID 통해서 메뉴 객체 가져와야함
            val menu = marketMenuRepository.findById(marketOrderSaveItem.menuId)

            if (menu.isPresent) {
                MarketOrderDetail(
                    orderDetailMarketOrder = saveOrderResult,
                    orderDetailMarketMenu = menu.get(),
                    menuCount = marketOrderSaveItem.menuCount
                )
            } else return MarketOrderSaveResponse("MENU NOT FOUND")
        }

        marketOrderDetailRepository.saveAll(convertedList)

        return MarketOrderSaveResponse("SUCCESS")
    }
}
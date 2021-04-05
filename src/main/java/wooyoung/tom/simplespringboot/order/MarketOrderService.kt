package wooyoung.tom.simplespringboot.order

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.dto.CommonSimpleResponse
import wooyoung.tom.simplespringboot.menu.MarketMenuRepository
import wooyoung.tom.simplespringboot.order.detail.MarketOrderDetailEntity
import wooyoung.tom.simplespringboot.order.detail.MarketOrderDetailRepository
import wooyoung.tom.simplespringboot.order.dto.MarketOrderFindResponse
import wooyoung.tom.simplespringboot.order.dto.MarketOrderFindResponseItem
import wooyoung.tom.simplespringboot.order.dto.MarketOrderSaveRequest
import wooyoung.tom.simplespringboot.restaurant.MarketRestaurantRepository
import java.time.LocalDate

@Service
open class MarketOrderService(
    private val marketOrderRepository: MarketOrderRepository,
    private val marketOrderDetailRepository: MarketOrderDetailRepository,
    private val marketMenuRepository: MarketMenuRepository,
    private val marketRestaurantRepository: MarketRestaurantRepository
) {

    // 오더 등록
    @Transactional
    open fun registerOrder(order: MarketOrderSaveRequest): CommonSimpleResponse {
        val restaurant = marketRestaurantRepository.findById(order.restaurantId)

        if (!restaurant.isPresent) {
            return CommonSimpleResponse(
                code = "Failed",
                message = "음식점을 찾지 못했습니다."
            )
        }

        // 먼저 전체 오더 하나 만든다.
        val newOrder = MarketOrderEntity(
            userId = order.userId,
            restaurant = restaurant.get(),
            orderDate = LocalDate.now()
        )

        // 새로 만든 오더 등록
        try {
            marketOrderRepository.save(newOrder)
        } catch (npe: NullPointerException) {
            return CommonSimpleResponse(
                code = "Failed",
                message = "오더 생성에 실패했습니다."
            )
        }

        // 새로만든 오더에 id 통해서 받아온 메뉴 리스트 순회하면서 order detail save
        order.menuList.forEach { marketOrderRequestItem ->
            // menu item 가져오기
            val menuItem = marketMenuRepository.findById(marketOrderRequestItem.menuId)

            if (!menuItem.isPresent) {
                return CommonSimpleResponse(
                    code = "Failed",
                    message = "메뉴를 불러오는 데 실패했습니다."
                )
            }

            // order detail item 하나 생성
            val newOrderDetail = MarketOrderDetailEntity(
                orderId = newOrder.id,
                menu = menuItem.get(),
                menuCount = marketOrderRequestItem.menuCount
            )

            // Order Detail save
            try {
                marketOrderDetailRepository.save(newOrderDetail)
            } catch (npe: NullPointerException) {
                return CommonSimpleResponse(
                    code = "Failed",
                    message = "오더 상세정보 생성에 실패했습니다."
                )
            }
        }

        return CommonSimpleResponse(
            code = "Success",
            message = "오더 생성에 성공했습니다."
        )
    }

    // 오더 조회
    open fun findReadyOrders(userId: Long): MarketOrderFindResponse {
        // 유저 아이디 통해서 준비중인 오더 조회
        val orderList = marketOrderRepository.findAllByUserIdAndOrderStatus(userId)

        if (orderList.isEmpty()) {
            return MarketOrderFindResponse(
                code = "Failed",
                message = "오더를 가져오는 데 실패했습니다."
            )
        }

        val convertedList = orderList.map { marketOrderEntity ->
            MarketOrderFindResponseItem(
                orderId = marketOrderEntity.id,
                restaurantName = marketOrderEntity.restaurant.name,
                totalPrice = marketOrderEntity.orderDetailList.sumOf {
                    (it.menu.price * it.menuCount)
                },
                orderDetailList = marketOrderEntity.orderDetailList
            )
        }

        return MarketOrderFindResponse(
            code = "Success",
            message = "${convertedList.size}건의 오더를 조회했습니다.",
            orders = convertedList
        )
    }
}
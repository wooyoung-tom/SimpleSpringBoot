package wooyoung.tom.simplespringboot.order

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.order.detail.MarketOrderDetailEntity
import wooyoung.tom.simplespringboot.order.detail.MarketOrderDetailRepository
import wooyoung.tom.simplespringboot.order.dto.MarketOrderSaveRequest
import wooyoung.tom.simplespringboot.order.dto.MarketOrderSaveResponse
import java.time.LocalDate

@Service
open class MarketOrderService(
    private val marketOrderRepository: MarketOrderRepository,
    private val marketOrderDetailRepository: MarketOrderDetailRepository
) {

    // 오더 등록
    @Transactional
    open fun registerOrder(order: MarketOrderSaveRequest): MarketOrderSaveResponse {
        // 먼저 전체 오더 하나 만든다.
        val newOrder = MarketOrderEntity(
            userId = order.userId,
            restaurantId = order.restaurantId,
            orderDate = LocalDate.now()
        )

        // 새로 만든 오더 등록
        try {
            marketOrderRepository.save(newOrder)
        } catch (npe: NullPointerException) {
            return MarketOrderSaveResponse(
                code = "Failed",
                message = "오더 생성에 실패했습니다."
            )
        }

        // 새로만든 오더에 id 통해서 받아온 메뉴 리스트 순회하면서 order detail save
        order.menuList.forEach { marketOrderRequestItem ->
            // order detail item 하나 생성
            val newOrderDetail = MarketOrderDetailEntity(
                orderId = newOrder.id,
                menuId = marketOrderRequestItem.menuId,
                menuCount = marketOrderRequestItem.menuCount
            )

            // Order Detail save
            try {
                marketOrderDetailRepository.save(newOrderDetail)
            } catch (npe: NullPointerException) {
                return MarketOrderSaveResponse(
                    code = "Failed",
                    message = "오더 상세정보 생성에 실패했습니다."
                )
            }
        }

        return MarketOrderSaveResponse(
            code = "Success",
            message = "오더 생성에 성공했습니다."
        )
    }
}
package wooyoung.tom.simplespringboot.order.detail

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.dto.CommonSimpleResponse
import wooyoung.tom.simplespringboot.menu.MarketMenuRepository
import wooyoung.tom.simplespringboot.order.MarketOrderRepository
import wooyoung.tom.simplespringboot.order.dto.MarketOrderDetailEditRequest

@Service
open class MarketOrderDetailService(
    private val marketOrderDetailRepository: MarketOrderDetailRepository,
    private val marketOrderRepository: MarketOrderRepository,
    private val marketMenuRepository: MarketMenuRepository
) {

    @Transactional
    open fun editOrderDetail(
        request: MarketOrderDetailEditRequest
    ): CommonSimpleResponse {
        // 오더 item 가져온다.
        val order = marketOrderRepository.findById(request.orderId)

        if (!order.isPresent) {
            return CommonSimpleResponse(
                code = "Failed",
                message = "오더가 존재하지 않습니다."
            )
        }

        // 오더 id 와 status 가지고 detail list 가져온다.
        val orderDetails = marketOrderDetailRepository
            .findAllByMarketOrderIdAndMenuStatus(request.orderId)

        if (orderDetails.isEmpty()) {
            return CommonSimpleResponse(
                code = "Failed",
                message = "상세 오더가 존재하지 않습니다."
            )
        }

        orderDetails.forEach { original ->
            original.menuStatus = false
        }

        try {
            marketOrderDetailRepository.saveAll(orderDetails)
        } catch (npe: NullPointerException) {
            return CommonSimpleResponse(
                code = "Failed",
                message = "오더 상세정보를 찾을 수 없습니다."
            )
        }

        val convertedMap = request.menuList.map { requestMenu ->
            val menu = marketMenuRepository.findById(requestMenu.menuId)

            if (!menu.isPresent) {
                return CommonSimpleResponse(
                    code = "Failed",
                    message = "메뉴를 찾을 수 없습니다."
                )
            }

            MarketOrderDetailEntity(
                marketOrder = order.get(),
                menu = menu.get(),
                menuCount = requestMenu.menuCount
            )
        }

        try {
            marketOrderDetailRepository.saveAll(convertedMap)
        } catch (e: IllegalArgumentException) {
            return CommonSimpleResponse(
                code = "Failed",
                message = "오더 상세정보를 찾을 수 없습니다."
            )
        }

        return CommonSimpleResponse(
            code = "Success",
            message = "오더 상세정보 수정에 성공하였습니다."
        )
    }
}
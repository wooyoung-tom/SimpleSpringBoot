package wooyoung.tom.simplespringboot.order

import org.springframework.web.bind.annotation.*
import wooyoung.tom.simplespringboot.CommonSimpleResponse
import wooyoung.tom.simplespringboot.order.detail.MarketOrderDetailService
import wooyoung.tom.simplespringboot.order.dto.*
import wooyoung.tom.simplespringboot.payment.dto.MarketPaymentRequest
import wooyoung.tom.simplespringboot.payment.dto.MarketPaymentResponse

@RestController
@RequestMapping("/orders")
open class MarketOrderController(
    private val marketOrderService: MarketOrderService,
    private val marketOrderDetailService: MarketOrderDetailService
) {

    // 오더 등록
    @PostMapping
    open fun registerOrder(
        @RequestBody order: MarketOrderSaveRequest
    ): MarketOrderSaveResponse {
        return marketOrderService.registerOrder(order)
    }

    // 오더 조회
    @GetMapping("/{id}")
    open fun findReadyOrders(
        @PathVariable id: Long
    ): MarketOrderFindResponse {
        return marketOrderService.findReadyOrders(id)
    }

    // 오더 삭제 (상태 Invalid 로 수정)
    @GetMapping("/delete/{id}")
    open fun deleteOrder(
        @PathVariable id: Long
    ): CommonSimpleResponse {
        return marketOrderService.deleteOrder(id)
    }

    // 오더 수정
    @PostMapping("/edit")
    open fun editOrder(
        @RequestBody request: MarketOrderDetailEditRequest
    ): CommonSimpleResponse {
        return marketOrderDetailService.editOrderDetail(request)
    }

    // 오더 상태 수정
    @PostMapping("/payment")
    open fun orderPayment(
        @RequestBody request: MarketPaymentRequest
    ): MarketPaymentResponse {
        return marketOrderService.orderPayment(request)
    }
}
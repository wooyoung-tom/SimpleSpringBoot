package wooyoung.tom.simplespringboot.order

import org.springframework.web.bind.annotation.*
import wooyoung.tom.simplespringboot.dto.CommonSimpleResponse
import wooyoung.tom.simplespringboot.order.dto.MarketOrderFindResponse
import wooyoung.tom.simplespringboot.order.dto.MarketOrderSaveRequest

@RestController
@RequestMapping("/orders")
open class MarketOrderController(
    private val marketOrderService: MarketOrderService
) {

    // 오더 등록
    @PostMapping
    open fun registerOrder(
        @RequestBody order: MarketOrderSaveRequest
    ): CommonSimpleResponse {
        return marketOrderService.registerOrder(order)
    }

    // 오더 조회
    @GetMapping("/{id}")
    open fun findReadyOrders(
        @PathVariable id: Long
    ): MarketOrderFindResponse {
        return marketOrderService.findReadyOrders(id)
    }
}
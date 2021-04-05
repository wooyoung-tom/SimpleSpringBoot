package wooyoung.tom.simplespringboot.order

import org.springframework.web.bind.annotation.*
import wooyoung.tom.simplespringboot.order.dto.MarketOrderFindResponse
import wooyoung.tom.simplespringboot.order.dto.MarketOrderSaveRequest
import wooyoung.tom.simplespringboot.order.dto.MarketOrderSaveResponse

@RestController
@RequestMapping("/orders")
open class MarketOrderController(
    private val marketOrderService: MarketOrderService
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
    open fun findOrders(
        @PathVariable id: Long
    ): MarketOrderFindResponse {
        return marketOrderService.findOrder(id)
    }
}
package wooyoung.tom.simplespringboot.order

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
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
}
package wooyoung.tom.simplespringboot.market.controller

import org.springframework.web.bind.annotation.*
import wooyoung.tom.simplespringboot.market.dto.order.BasketItem
import wooyoung.tom.simplespringboot.market.dto.order.MarketOrderSaveItem
import wooyoung.tom.simplespringboot.market.dto.order.MarketOrderSaveResponse
import wooyoung.tom.simplespringboot.market.service.MarketOrderService

@RestController
open class MarketOrderController(
    private val marketOrderService: MarketOrderService
) {

//    @GetMapping("/market/orders/{id}")
//    open fun findReadyOrdersByUserId(
//        @PathVariable("id") userId: Long
//    ): List<BasketItem> {
//        return marketOrderService.findReadyOrderListByUserId(userId)
//    }

//    @PostMapping("/market/orders/{id}")
//    open fun saveNewOrder(
//        @PathVariable("id") userId: Long,
//        @RequestBody order: List<MarketOrderSaveItem>
//    ): MarketOrderSaveResponse {
//        return marketOrderService.saveOrder(userId, order)
//    }
}
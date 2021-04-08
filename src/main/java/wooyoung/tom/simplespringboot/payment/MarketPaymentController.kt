package wooyoung.tom.simplespringboot.payment

import org.springframework.web.bind.annotation.*
import wooyoung.tom.simplespringboot.utils.CommonSimpleResponse
import wooyoung.tom.simplespringboot.payment.dto.MarketPaymentLaterResponse

@RestController
@RequestMapping("/payment")
open class MarketPaymentController(
    private val marketPaymentService: MarketPaymentService
) {

    @GetMapping("/{id}")
    fun findNotPaidPayment(
        @PathVariable id: Long,
    ): MarketPaymentLaterResponse {
        return marketPaymentService.findNotPaidPayment(id)
    }

    @PatchMapping("/{paymentId}")
    fun cancelPayment(
        @PathVariable paymentId: Long
    ): CommonSimpleResponse {
        return marketPaymentService.cancelPayment(paymentId)
    }
}
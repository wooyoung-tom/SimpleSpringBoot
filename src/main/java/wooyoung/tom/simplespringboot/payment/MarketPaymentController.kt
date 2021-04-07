package wooyoung.tom.simplespringboot.payment

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
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
}
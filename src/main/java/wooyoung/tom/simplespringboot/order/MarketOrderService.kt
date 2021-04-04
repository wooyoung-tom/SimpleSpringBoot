package wooyoung.tom.simplespringboot.order

import org.springframework.stereotype.Service

@Service
open class MarketOrderService(
    private val marketOrderRepository: MarketOrderRepository
) {


}
package wooyoung.tom.simplespringboot.market.service

import org.springframework.stereotype.Service
import wooyoung.tom.simplespringboot.market.repository.MarketOrderRepository

@Service
open class MarketOrderService(
    private val marketOrderRepository: MarketOrderRepository
) {

}
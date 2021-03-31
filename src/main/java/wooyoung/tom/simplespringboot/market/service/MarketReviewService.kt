package wooyoung.tom.simplespringboot.market.service

import org.springframework.stereotype.Service
import wooyoung.tom.simplespringboot.market.repository.MarketReviewRepository

@Service
open class MarketReviewService(
    private val marketReviewRepository: MarketReviewRepository
) {

}
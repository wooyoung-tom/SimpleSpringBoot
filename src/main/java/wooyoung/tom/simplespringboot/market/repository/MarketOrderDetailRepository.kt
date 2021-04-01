package wooyoung.tom.simplespringboot.market.repository

import org.springframework.data.jpa.repository.JpaRepository
import wooyoung.tom.simplespringboot.market.entity.MarketOrderDetail

interface MarketOrderDetailRepository: JpaRepository<MarketOrderDetail, Long> {
}
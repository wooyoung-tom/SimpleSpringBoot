package wooyoung.tom.simplespringboot.order.detail

import org.springframework.data.jpa.repository.JpaRepository

interface MarketOrderDetailRepository : JpaRepository<MarketOrderDetailEntity, Long> {
}
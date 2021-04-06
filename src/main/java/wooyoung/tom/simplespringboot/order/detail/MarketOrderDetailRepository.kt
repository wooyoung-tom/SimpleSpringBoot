package wooyoung.tom.simplespringboot.order.detail

import org.springframework.data.jpa.repository.JpaRepository

interface MarketOrderDetailRepository : JpaRepository<MarketOrderDetailEntity, Long> {

    // order id 통해서 order detail 가져온다.
    fun findAllByMarketOrderId(orderId: Long): List<MarketOrderDetailEntity>

    fun findAllByMarketOrderIdAndMenuStatus(
        orderId: Long, status: Boolean = true
    ): List<MarketOrderDetailEntity>

    fun findAllByMarketOrderIdAndMenuId(orderId: Long, menuId: Long): MarketOrderDetailEntity?
}
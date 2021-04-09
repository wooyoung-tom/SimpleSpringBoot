package wooyoung.tom.simplespringboot.order

import org.springframework.data.jpa.repository.JpaRepository

interface MarketOrderRepository : JpaRepository<MarketOrderEntity, Long> {

    // 유저 ID 통해 준비중인 오더 조회
    fun findAllByUserIdAndOrderStatus(
        userId: Long, orderStatus: String = "Ready"
    ): List<MarketOrderEntity>

    // 유저 id 와 음식점 id 로 준비중인 오더 조회
    fun findMarketOrderEntityByUserIdAndRestaurantIdAndOrderStatus(
        userId: Long, restaurantId: Long, orderStatus: String = "Ready"
    ): MarketOrderEntity?

    fun findAllByIdIn(idList: List<Long>): List<MarketOrderEntity>

    // 결제 id 통해 order 가져옴
    fun findAllByPaymentId(paymentId: Long): List<MarketOrderEntity>

    // 유저 id 통해 오더 전체 가져온다.
    fun findAllByUserId(userId: Long): List<MarketOrderEntity>
}
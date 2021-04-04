package wooyoung.tom.simplespringboot.order

import org.springframework.data.jpa.repository.JpaRepository

interface MarketOrderRepository : JpaRepository<MarketOrderEntity, Long> {

    // 유저 ID 통해 오더 조회
    fun findAllByUserId(userId: Long): List<MarketOrderEntity>
}
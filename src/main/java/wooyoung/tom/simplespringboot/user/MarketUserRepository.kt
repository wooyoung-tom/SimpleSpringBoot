package wooyoung.tom.simplespringboot.user

import org.springframework.data.jpa.repository.JpaRepository
import wooyoung.tom.simplespringboot.user.data.MarketUserEntity

interface MarketUserRepository : JpaRepository<MarketUserEntity, Long> {

    // 유저 이름을 통해 찾는다.
    fun findMarketUserByUserId(userId: String): MarketUserEntity?
}
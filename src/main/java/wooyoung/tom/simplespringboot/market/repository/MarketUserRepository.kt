package wooyoung.tom.simplespringboot.market.repository

import org.springframework.data.jpa.repository.JpaRepository
import wooyoung.tom.simplespringboot.market.entity.MarketUser

interface MarketUserRepository : JpaRepository<MarketUser, Long> {

    fun findMarketUserByName(name: String): MarketUser?
}
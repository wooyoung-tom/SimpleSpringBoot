package wooyoung.tom.simplespringboot.menu

import org.springframework.data.jpa.repository.JpaRepository

interface MarketMenuRepository: JpaRepository<MarketMenuEntity, Long> {
}
package wooyoung.tom.simplespringboot.payment

import org.springframework.data.jpa.repository.JpaRepository

interface MarketPaymentRepository: JpaRepository<MarketPaymentEntity, Long> {
}
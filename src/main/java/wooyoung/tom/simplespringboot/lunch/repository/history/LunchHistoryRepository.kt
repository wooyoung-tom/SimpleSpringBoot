package wooyoung.tom.simplespringboot.lunch.repository.history

import org.springframework.data.jpa.repository.JpaRepository

interface LunchHistoryRepository: JpaRepository<LunchHistory, Long> {
}
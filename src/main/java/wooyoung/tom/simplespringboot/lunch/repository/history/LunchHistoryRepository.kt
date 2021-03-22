package wooyoung.tom.simplespringboot.lunch.repository.history

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface LunchHistoryRepository: JpaRepository<LunchHistory, Long> {

    fun findLunchHistoryByNameAndDate(name: String, date: String): Optional<LunchHistory>
}
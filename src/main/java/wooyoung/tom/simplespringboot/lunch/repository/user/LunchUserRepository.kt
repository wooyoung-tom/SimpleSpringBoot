package wooyoung.tom.simplespringboot.lunch.repository.user

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface LunchUserRepository : JpaRepository<LunchUser, Long> {

    fun findLunchUserByName(name: String): Optional<LunchUser>
}
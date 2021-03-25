package wooyoung.tom.simplespringboot.lunch.repository.user

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface LunchUserRepository : JpaRepository<LunchUser, String> {

    fun findLunchUserByName(name: String): Optional<LunchUser>

    fun findAllByTeamName(teamName: String): List<LunchUser>
}
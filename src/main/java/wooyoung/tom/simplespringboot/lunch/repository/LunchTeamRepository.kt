package wooyoung.tom.simplespringboot.lunch.repository

import org.springframework.data.jpa.repository.JpaRepository
import wooyoung.tom.simplespringboot.lunch.entity.LunchTeam

interface LunchTeamRepository: JpaRepository<LunchTeam, String> {
}
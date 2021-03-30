package wooyoung.tom.simplespringboot.lunch.service

import org.springframework.stereotype.Service
import wooyoung.tom.simplespringboot.lunch.entity.LunchUser
import wooyoung.tom.simplespringboot.lunch.repository.LunchTeamRepository

@Service
open class LunchTeamService(
    private val lunchTeamRepository: LunchTeamRepository
) {

}
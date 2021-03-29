package wooyoung.tom.simplespringboot.lunch.repository

import org.springframework.data.jpa.repository.JpaRepository
import wooyoung.tom.simplespringboot.lunch.entity.LunchUser

interface LunchUserRepository: JpaRepository<LunchUser, String> {
}
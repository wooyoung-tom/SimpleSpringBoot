package wooyoung.tom.simplespringboot.lunch.repository.user

import org.springframework.data.jpa.repository.JpaRepository

interface LunchUserRepository : JpaRepository<LunchUser, String> {
}
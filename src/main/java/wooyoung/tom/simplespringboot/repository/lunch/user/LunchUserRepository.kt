package wooyoung.tom.simplespringboot.repository.lunch.user

import org.springframework.data.jpa.repository.JpaRepository

interface LunchUserRepository : JpaRepository<User, Long> {
}
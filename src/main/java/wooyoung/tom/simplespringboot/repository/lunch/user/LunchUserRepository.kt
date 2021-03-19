package wooyoung.tom.simplespringboot.repository.lunch.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LunchUserRepository : JpaRepository<LunchUser, String> {
}
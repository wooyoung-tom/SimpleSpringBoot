package wooyoung.tom.simplespringboot.repository.user.jpa

import wooyoung.tom.simplespringboot.domain.User
import java.util.*

interface JpaUserRepository {
    // Create
    fun create(user: User): User

    // Read
    fun findUserById(id: String): Optional<User>
    fun findAllUser(): List<User>

    // Update
    fun updateUserCredit(user: User, credit: Long): Long
}
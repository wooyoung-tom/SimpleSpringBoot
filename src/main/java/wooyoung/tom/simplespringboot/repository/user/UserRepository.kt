package wooyoung.tom.simplespringboot.repository.user

import wooyoung.tom.simplespringboot.domain.User
import java.util.*

interface UserRepository {
    // Create
    fun createUser(user: User): User

    // Read
    fun findUserById(id: String): Optional<User>
    fun findAllUser(): List<User>

    // Update
    fun updateUserCredit(userId: String, credit: Long): Int
}
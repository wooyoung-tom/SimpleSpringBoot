package wooyoung.tom.simplespringboot.repository.sendygo.user

import java.util.*

interface UserRepository {
    // Create
    fun create(user: User): User

    // Read
    fun findUserById(id: String): Optional<User>
    fun findAllUser(): List<User>

    // Update
    fun updateUserCredit(userId: String, credit: Long): Int
}
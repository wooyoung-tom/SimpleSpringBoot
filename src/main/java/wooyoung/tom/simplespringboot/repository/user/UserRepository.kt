package wooyoung.tom.simplespringboot.repository.user

import wooyoung.tom.simplespringboot.domain.User

interface UserRepository {
    // Create
    fun createUser(user: User): User

    // Read
    fun findUserById(id: String): User?
    fun findAllUser(): List<User>

    // Update
    fun updateUser(user: User): User
}
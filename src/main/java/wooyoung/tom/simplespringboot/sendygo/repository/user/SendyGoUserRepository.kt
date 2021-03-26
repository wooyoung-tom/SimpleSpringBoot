package wooyoung.tom.simplespringboot.sendygo.repository.user

import java.util.*

interface SendyGoUserRepository {
    // Create
    fun create(sendyGoUser: SendyGoUser): SendyGoUser

    // Read
    fun findUserById(id: String): Optional<SendyGoUser>
    fun findAllUser(): List<SendyGoUser>

    // Update
    fun updateUserCredit(userId: String, credit: Long): Int
}
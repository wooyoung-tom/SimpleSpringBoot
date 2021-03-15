package wooyoung.tom.simplespringboot.repository.user.jpa

import org.springframework.stereotype.Repository
import wooyoung.tom.simplespringboot.domain.User
import wooyoung.tom.simplespringboot.repository.user.UserRepository
import java.util.*
import javax.persistence.EntityManager

open class JpaUserRepositoryImpl(
    private val entityManager: EntityManager
) : JpaUserRepository {

    override fun create(user: User): User {
        entityManager.persist(user)
        return user
    }

    override fun findUserById(id: String): Optional<User> {
        val user = entityManager.find(User::class.java, id)
        return Optional.ofNullable(user)
    }

    override fun findAllUser(): List<User> {
        return entityManager.createQuery("SELECT u from User u", User::class.java)
            .resultList
    }

    override fun updateUserCredit(user: User, credit: Long): Long {
        user.credit += credit
        user.accumulated_credit += credit

        return credit
    }
}
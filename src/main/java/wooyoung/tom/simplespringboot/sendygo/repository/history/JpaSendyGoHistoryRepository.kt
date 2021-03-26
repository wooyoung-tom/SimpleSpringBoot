package wooyoung.tom.simplespringboot.sendygo.repository.history

import org.springframework.stereotype.Repository
import wooyoung.tom.simplespringboot.sendygo.dto.HistoryRequest
import javax.persistence.EntityManager

@Repository
open class JpaSendyGoHistoryRepository(
    private val entityManager: EntityManager
) : SendyGoHistoryRepository {

    override fun createHistory(history: HistoryRequest): Long {
        entityManager.persist(history)
        return 1
    }

    override fun findAllHistoryByUserId(userId: String): List<SendyGoHistory> {
        return entityManager.createQuery(
            "SELECT h FROM SendyGoHistory h WHERE h.userId = :userId", SendyGoHistory::class.java
        ).setParameter("userId", userId).resultList
    }
}
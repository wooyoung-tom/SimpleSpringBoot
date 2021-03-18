package wooyoung.tom.simplespringboot.repository.sendygo.history

import org.springframework.stereotype.Repository
import wooyoung.tom.simplespringboot.dto.sendygo.HistoryRequest
import javax.persistence.EntityManager

@Repository
open class JpaHistoryRepository(
    private val entityManager: EntityManager
) : HistoryRepository {

    override fun createHistory(history: HistoryRequest): Long {
        entityManager.persist(history)
        return 1
    }

    override fun findAllHistoryByUserId(userId: String): List<History> {
        return entityManager.createQuery(
            "SELECT h FROM History h WHERE h.userId = :userId", History::class.java
        ).setParameter("userId", userId).resultList
    }
}
package wooyoung.tom.simplespringboot.repository.history

import org.springframework.stereotype.Repository
import wooyoung.tom.simplespringboot.domain.History
import wooyoung.tom.simplespringboot.dto.HistoryRequestDTO
import javax.persistence.EntityManager

@Repository
open class JpaHistoryRepository(
    private val entityManager: EntityManager
) : HistoryRepository {

    override fun createHistory(history: HistoryRequestDTO): Long {
        entityManager.persist(history)
        return 1
    }

    override fun findAllHistoryByUserId(userId: String): List<History> {
        return entityManager.createQuery(
            "SELECT h FROM History h WHERE h.userId = :userId", History::class.java
        ).setParameter("userId", userId).resultList
    }
}
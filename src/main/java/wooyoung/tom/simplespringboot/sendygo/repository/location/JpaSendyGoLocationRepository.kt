package wooyoung.tom.simplespringboot.sendygo.repository.location

import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
open class JpaSendyGoLocationRepository(
    private val entityManager: EntityManager
) : SendyGoLocationRepository {

    override fun findLocationById(id: Long): SendyGoLocation? {
        return entityManager.find(SendyGoLocation::class.java, id)
    }

    override fun findAllLocation(): List<SendyGoLocation> {
        return entityManager.createQuery("SELECT l FROM SendyGoLocation l", SendyGoLocation::class.java).resultList
    }
}
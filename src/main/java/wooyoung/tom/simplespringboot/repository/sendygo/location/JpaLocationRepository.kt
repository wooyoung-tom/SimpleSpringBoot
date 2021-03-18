package wooyoung.tom.simplespringboot.repository.sendygo.location

import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
open class JpaLocationRepository(
    private val entityManager: EntityManager
) : LocationRepository {

    override fun findLocationById(id: Long): Location? {
        return entityManager.find(Location::class.java, id)
    }

    override fun findAllLocation(): List<Location> {
        return entityManager.createQuery("SELECT l FROM Location l", Location::class.java).resultList
    }
}
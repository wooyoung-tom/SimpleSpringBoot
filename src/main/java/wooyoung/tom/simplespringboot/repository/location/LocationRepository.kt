package wooyoung.tom.simplespringboot.repository.location

import wooyoung.tom.simplespringboot.domain.Location
import wooyoung.tom.simplespringboot.dto.LocationDTO

interface LocationRepository {

    // Create -> Location 생성할 이유가 없어서 Pass

    // Read
    fun findLocationById(id: Long): Location?
    fun findAllLocation(): List<Location>

    // Update

    // Delete
}
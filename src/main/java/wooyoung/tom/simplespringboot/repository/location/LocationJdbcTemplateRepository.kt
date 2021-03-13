package wooyoung.tom.simplespringboot.repository.location

import org.springframework.stereotype.Repository
import wooyoung.tom.simplespringboot.dto.LocationDTO

@Repository
class LocationJdbcTemplateRepository : LocationRepository {

    override fun findSrcAndDest(): LocationDTO {
        TODO("Not yet implemented")
    }
}
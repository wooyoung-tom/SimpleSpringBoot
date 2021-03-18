package wooyoung.tom.simplespringboot.repository.sendygo.location

interface LocationRepository {

    // Create -> Location 생성할 이유가 없어서 Pass

    // Read
    fun findLocationById(id: Long): Location?
    fun findAllLocation(): List<Location>

    // Update

    // Delete
}
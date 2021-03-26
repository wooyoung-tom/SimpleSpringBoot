package wooyoung.tom.simplespringboot.sendygo.repository.location

interface SendyGoLocationRepository {

    // Create -> Location 생성할 이유가 없어서 Pass

    // Read
    fun findLocationById(id: Long): SendyGoLocation?
    fun findAllLocation(): List<SendyGoLocation>

    // Update

    // Delete
}
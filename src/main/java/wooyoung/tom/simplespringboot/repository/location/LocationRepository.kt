package wooyoung.tom.simplespringboot.repository.location

import wooyoung.tom.simplespringboot.dto.LocationDTO

interface LocationRepository {

    // Create -> Location 생성할 이유가 없어서 Pass

    // Read
    // 출발지와 도착지 읽어오는 함수
    fun findSrcAndDest(): LocationDTO
}
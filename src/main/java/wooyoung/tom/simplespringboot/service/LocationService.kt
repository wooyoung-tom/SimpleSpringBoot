package wooyoung.tom.simplespringboot.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.dto.LocationDTO
import wooyoung.tom.simplespringboot.repository.location.LocationRepository
import kotlin.random.Random

@Service
open class LocationService(
    private val locationRepository: LocationRepository
) {

    // 출발지와 도착지 받아오는 함수
    @Transactional
    open fun getSrcAndDestination(): LocationDTO {
        // 랜덤으로 1..20 ID 두 개 선택
        val randomIdList = List(2) { Random.nextLong(1, 20) }

        // Null Check 해주어야 한다.
        val src = locationRepository.findLocationById(randomIdList[0])
        val dest = locationRepository.findLocationById(randomIdList[1])

        return LocationDTO(src, dest)
    }
}
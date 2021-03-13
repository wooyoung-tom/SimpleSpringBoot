package wooyoung.tom.simplespringboot.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.dto.LocationDTO
import wooyoung.tom.simplespringboot.repository.location.LocationRepository

@Service
open class LocationService(
    private val locationRepository: LocationRepository
) {

    // 랜덤으로 두 개의 ID를 추출하여 리스트로 반환하는 함수
    private fun getRandomLocationId() =  (1..20).shuffled().take(2).map { it.toLong() }

    // 출발지와 도착지 받아오는 함수
    @Transactional
    open fun getSrcAndDestination(): LocationDTO {
        val src = locationRepository.findLocationById(getRandomLocationId()[0])
        val dest = locationRepository.findLocationById(getRandomLocationId()[1])

        return LocationDTO(src, dest)
    }
}
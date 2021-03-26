package wooyoung.tom.simplespringboot.sendygo.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.sendygo.dto.LocationResult
import wooyoung.tom.simplespringboot.sendygo.repository.location.SendyGoLocationRepository

@Service
open class SendyGoLocationService(
    private val sendyGoLocationRepository: SendyGoLocationRepository
) {

    // 랜덤으로 두 개의 ID를 추출하여 리스트로 반환하는 함수
    private fun getRandomLocationId() =  (1..20).shuffled().take(2).map { it.toLong() }

    // 출발지와 도착지 받아오는 함수
    @Transactional
    open fun getSrcAndDestination(): LocationResult {
        val src = sendyGoLocationRepository.findLocationById(getRandomLocationId()[0])
        val dest = sendyGoLocationRepository.findLocationById(getRandomLocationId()[1])

        return LocationResult(src, dest)
    }
}
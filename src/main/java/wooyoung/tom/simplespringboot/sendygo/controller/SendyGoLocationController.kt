package wooyoung.tom.simplespringboot.sendygo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import wooyoung.tom.simplespringboot.sendygo.dto.LocationResult
import wooyoung.tom.simplespringboot.sendygo.service.SendyGoLocationService

@RestController
open class SendyGoLocationController(
    private val sendyGoLocationService: SendyGoLocationService
) {

    @GetMapping("/location/offers")
    open fun getSrcAndDestinationLocation(): LocationResult {
        return sendyGoLocationService.getSrcAndDestination()
    }
}
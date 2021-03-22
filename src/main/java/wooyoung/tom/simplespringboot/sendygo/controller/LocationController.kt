package wooyoung.tom.simplespringboot.sendygo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import wooyoung.tom.simplespringboot.sendygo.dto.LocationResult
import wooyoung.tom.simplespringboot.sendygo.service.LocationService

@RestController
open class LocationController(
    private val locationService: LocationService
) {

    @GetMapping("/location/offers")
    open fun getSrcAndDestinationLocation(): LocationResult {
        return locationService.getSrcAndDestination()
    }
}
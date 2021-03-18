package wooyoung.tom.simplespringboot.controller.sendygo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import wooyoung.tom.simplespringboot.dto.LocationDTO
import wooyoung.tom.simplespringboot.service.sendygo.LocationService

@RestController
open class LocationController(
    private val locationService: LocationService
) {

    @GetMapping("/location/offers")
    open fun getSrcAndDestinationLocation(): LocationDTO {
        return locationService.getSrcAndDestination()
    }
}
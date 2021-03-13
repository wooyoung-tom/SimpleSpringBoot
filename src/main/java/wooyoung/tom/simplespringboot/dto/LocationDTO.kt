package wooyoung.tom.simplespringboot.dto

import wooyoung.tom.simplespringboot.domain.Location

data class LocationDTO(
    val src: Location,
    val dest: Location
)
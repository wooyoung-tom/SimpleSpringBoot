package wooyoung.tom.simplespringboot.dto

import wooyoung.tom.simplespringboot.repository.sendygo.location.Location

data class LocationDTO(
    val src: Location? = null,
    val dest: Location? = null
)
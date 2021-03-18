package wooyoung.tom.simplespringboot.dto.sendygo

import wooyoung.tom.simplespringboot.repository.sendygo.location.Location

data class LocationResult(
    val src: Location? = null,
    val dest: Location? = null
)
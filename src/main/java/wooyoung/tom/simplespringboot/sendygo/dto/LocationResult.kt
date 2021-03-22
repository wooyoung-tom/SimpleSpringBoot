package wooyoung.tom.simplespringboot.sendygo.dto

import wooyoung.tom.simplespringboot.sendygo.repository.location.Location

data class LocationResult(
    val src: Location? = null,
    val dest: Location? = null
)
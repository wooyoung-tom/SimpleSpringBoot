package wooyoung.tom.simplespringboot.sendygo.dto

import wooyoung.tom.simplespringboot.sendygo.repository.location.SendyGoLocation

data class LocationResult(
    val src: SendyGoLocation? = null,
    val dest: SendyGoLocation? = null
)
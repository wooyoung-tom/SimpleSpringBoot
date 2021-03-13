package wooyoung.tom.simplespringboot.dto

import wooyoung.tom.simplespringboot.domain.Location

data class LocationDTO(
    val src: Location? = null,
    val dest: Location? = null
)
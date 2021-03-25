package wooyoung.tom.simplespringboot.lunch.dto.user

import wooyoung.tom.simplespringboot.lunch.repository.user.LunchUser

data class LunchUserResponse(
    val selected: Boolean,
    val message: String,
    val body: LunchUser? = null
)
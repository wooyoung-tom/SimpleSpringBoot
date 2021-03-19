package wooyoung.tom.simplespringboot.dto.lunch.user

import wooyoung.tom.simplespringboot.repository.lunch.user.LunchUser

data class LunchUserResponse(
    val message: String,
    val body: LunchUser?
)
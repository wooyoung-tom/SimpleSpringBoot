package wooyoung.tom.simplespringboot.lunch.dto.user

import wooyoung.tom.simplespringboot.lunch.repository.user.LunchUser

data class LunchUserResponse(
    val message: String,
    val body: LunchUser?
)
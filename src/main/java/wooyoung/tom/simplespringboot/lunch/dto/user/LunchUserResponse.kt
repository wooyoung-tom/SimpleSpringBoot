package wooyoung.tom.simplespringboot.lunch.dto.user

import wooyoung.tom.simplespringboot.lunch.entity.LunchUser

data class LunchUserResponse(
    val code: String,
    val message: String,
    val body: LunchUser?
)
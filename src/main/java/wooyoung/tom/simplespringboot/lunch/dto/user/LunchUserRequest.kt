package wooyoung.tom.simplespringboot.lunch.dto.user

import com.google.gson.annotations.SerializedName

data class LunchUserRequest(
    val name: String,
    @SerializedName("team_name")
    val teamName: String
)
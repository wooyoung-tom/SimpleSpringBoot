package wooyoung.tom.simplespringboot.lunch.dto.history

import com.google.gson.annotations.SerializedName

data class LunchHistoryRequest(
    val name: String,
    @SerializedName("team_name")
    val teamName: String,
    @SerializedName("h_date")
    val historyDate: String,
    val category: String
)

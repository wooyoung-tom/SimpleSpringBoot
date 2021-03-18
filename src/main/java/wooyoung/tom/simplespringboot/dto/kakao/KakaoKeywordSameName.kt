package wooyoung.tom.simplespringboot.dto.kakao

import com.google.gson.annotations.SerializedName

data class KakaoKeywordSameName(
    @SerializedName("keyword")
    val keyword: String,
    @SerializedName("region")
    val region: List<String>,
    @SerializedName("selected_region")
    val selectedRegion: String
)
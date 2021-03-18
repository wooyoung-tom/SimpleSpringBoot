package wooyoung.tom.simplespringboot.dto.kakao

import com.google.gson.annotations.SerializedName

data class KakaoKeywordMeta(
    @SerializedName("is_end")
    val isEnd: Boolean,
    @SerializedName("pageable_count")
    val pageableCount: Int,
    @SerializedName("same_name")
    val sameName: KakaoKeywordSameName,
    @SerializedName("total_count")
    val totalCount: Int
)

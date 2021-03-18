package wooyoung.tom.simplespringboot.repository.lunch.kakao

import retrofit2.Call
import retrofit2.http.Query
import wooyoung.tom.simplespringboot.dto.kakao.KakaoKeywordResult

interface KakaoApiRepository {

    fun getKeywordSearchResult(
        query: String,
        category: String,
        lat: String,
        lng: String,
        radius: Int,
        page: Int,
        size: Int
    ): Call<KakaoKeywordResult>


}
package wooyoung.tom.simplespringboot.lunch.repository.kakao

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import wooyoung.tom.simplespringboot.lunch.dto.kakao.KakaoKeywordResponse

interface KakaoApiRepository {

    // 키워드 검색하는 API 호출
    @GET("/v2/local/search/keyword.json")
    fun getKeywordSearchResult(
        @Query("query") query: String,
        @Query("category_group_code") category: String,
        @Query("y") lat: String,
        @Query("x") lng: String,
        @Query("radius") radius: Int,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Call<KakaoKeywordResponse>
}
package wooyoung.tom.simplespringboot.repository.lunch.kakao

import org.springframework.stereotype.Repository
import retrofit2.Call
import retrofit2.Retrofit
import wooyoung.tom.simplespringboot.dto.kakao.KakaoKeywordResult

@Repository
open class KakaoApiRepositoryImpl(
    private val kakaoRetrofitBuilder: Retrofit
) : KakaoApiRepository {

    private val kakaoApiRetrofit = kakaoRetrofitBuilder.create(KakaoApiRetrofit::class.java)

    override fun getKeywordSearchResult(
        query: String,
        category: String,
        lat: String,
        lng: String,
        radius: Int,
        page: Int,
        size: Int
    ): Call<KakaoKeywordResult> {
        return kakaoApiRetrofit.getKeywordSearchResult(query, category, lat, lng, radius, page, size)
    }
}
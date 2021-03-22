package wooyoung.tom.simplespringboot.lunch.service

import org.springframework.stereotype.Service
import wooyoung.tom.simplespringboot.lunch.repository.kakao.KakaoApiRepository

@Service
open class KakaoApiService(
    private val kakaoApiRepository: KakaoApiRepository
) {

    fun searchByKeyword(query: String, lat: String, lng: String, page: Int) {
        val response = kakaoApiRepository.getKeywordSearchResult(
            query = query, category = "FD6", lat = lat, lng = lng, radius = 500, page = page, size = 15
        ).execute()

        // 성공 및 null 이 아닐 때
        if (response.isSuccessful && response.body() != null) {

        }
    }
}
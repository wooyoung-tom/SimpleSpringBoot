package wooyoung.tom.simplespringboot.lunch.service

import org.springframework.stereotype.Service
import wooyoung.tom.simplespringboot.lunch.dto.kakao.KakaoKeywordResponse
import wooyoung.tom.simplespringboot.lunch.repository.kakao.KakaoApiRepository

@Service
open class KakaoApiService(
    private val kakaoApiRepository: KakaoApiRepository
) {

    private val key = "KakaoAK 104a6d4a4c8b35ff6eeec02cc1148cde"

    open fun searchByKeyword(query: String, lat: String, lng: String, page: Int): KakaoKeywordResponse? {
        val response = kakaoApiRepository.getKeywordSearchResult(
            key, query = query, category = "FD6", lat = lat, lng = lng, radius = 500, page = page
        ).execute()

        // 성공 및 null 이 아닐 때
        return if (response.isSuccessful) response.body() else null
    }
}
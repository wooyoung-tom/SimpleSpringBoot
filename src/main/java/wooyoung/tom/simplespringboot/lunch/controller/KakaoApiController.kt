package wooyoung.tom.simplespringboot.lunch.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import wooyoung.tom.simplespringboot.lunch.dto.kakao.KakaoKeywordResponse
import wooyoung.tom.simplespringboot.lunch.service.KakaoApiService

@RestController
open class KakaoApiController(
    private val kakaoApiService: KakaoApiService
) {

    @GetMapping("/lunch/search")
    open fun searchByKeyword(
        @RequestParam query: String,
        @RequestParam lat: String,
        @RequestParam lng: String,
        @RequestParam page: Int
    ): KakaoKeywordResponse? {
        return kakaoApiService.searchByKeyword(query, lat, lng, page)
    }
}
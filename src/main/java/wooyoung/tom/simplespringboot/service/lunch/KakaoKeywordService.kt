package wooyoung.tom.simplespringboot.service.lunch

import org.springframework.stereotype.Service
import wooyoung.tom.simplespringboot.repository.lunch.kakao.KakaoApiRepository

@Service
open class KakaoKeywordService(
    private val kakaoApiRepository: KakaoApiRepository
) {

}
package wooyoung.tom.simplespringboot.dto.lunch.kakao

data class KakaoKeywordResponse(
    val meta: KakaoKeywordMeta,
    val documents: List<KakaoKeywordDocument>
)
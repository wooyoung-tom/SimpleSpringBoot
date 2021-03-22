package wooyoung.tom.simplespringboot.lunch.dto.kakao

data class KakaoKeywordResponse(
    val meta: KakaoKeywordMeta,
    val documents: List<KakaoKeywordDocument>
)
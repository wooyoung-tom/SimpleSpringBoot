package wooyoung.tom.simplespringboot.dto.lunch.kakao

data class KakaoKeywordResult(
    val meta: KakaoKeywordMeta,
    val documents: List<KakaoKeywordDocument>
)
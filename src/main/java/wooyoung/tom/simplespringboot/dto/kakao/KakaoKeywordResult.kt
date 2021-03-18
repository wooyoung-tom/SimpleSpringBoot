package wooyoung.tom.simplespringboot.dto.kakao

data class KakaoKeywordResult(
    val meta: KakaoKeywordMeta,
    val documents: List<KakaoKeywordDocument>
)
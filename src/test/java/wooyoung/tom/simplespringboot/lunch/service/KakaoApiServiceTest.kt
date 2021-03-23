package wooyoung.tom.simplespringboot.lunch.service

import okhttp3.OkHttpClient
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import wooyoung.tom.simplespringboot.lunch.repository.kakao.KakaoApiRepository

@Transactional
internal open class KakaoApiServiceTest {

    private lateinit var okHttpClient: OkHttpClient
    private lateinit var retrofit: Retrofit
    private lateinit var kakaoApiRepository: KakaoApiRepository

    @BeforeEach
    fun beforeAll() {
        okHttpClient = OkHttpClient()
        retrofit = Retrofit.Builder().baseUrl("https://dapi.kakao.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        kakaoApiRepository = retrofit.create(KakaoApiRepository::class.java)
    }
}
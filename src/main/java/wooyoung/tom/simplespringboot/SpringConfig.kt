package wooyoung.tom.simplespringboot

import okhttp3.OkHttpClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Configuration
open class SpringConfig {

//    @Bean
//    open fun okHttpClient(): OkHttpClient = OkHttpClient.Builder().build()

//    @Bean
//    open fun kakaoRetrofitBuilder(okHttpClient: OkHttpClient): Retrofit {
//        return Retrofit.Builder().baseUrl("https://dapi.kakao.com")
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(okHttpClient)
//            .build()
//    }
}
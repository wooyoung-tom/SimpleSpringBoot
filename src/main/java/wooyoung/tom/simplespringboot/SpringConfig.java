package wooyoung.tom.simplespringboot;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import wooyoung.tom.simplespringboot.lunch.repository.KakaoApiRepository;

@Configuration
public class SpringConfig {

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder().build();
    }

    @Bean
    public Retrofit kakaoRetrofitBuilder(OkHttpClient okHttpClient) {
        return new Retrofit.Builder().baseUrl("https://dapi.kakao.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Bean
    public KakaoApiRepository kakaoApiRepository() {
        return kakaoRetrofitBuilder(okHttpClient()).create(KakaoApiRepository.class);
    }
}
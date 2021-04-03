package wooyoung.tom.simplespringboot.restaurant

import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional

@RunWith(SpringRunner::class)
@SpringBootTest
@Transactional
internal open class MarketRestaurantServiceTest {

    @Autowired
    private lateinit var marketRestaurantRepository: MarketRestaurantRepository

    @Test
    fun `음식점 ID로 메뉴 리스트 가져오기`() {
        val givenRestaurantId: Long = 5

        // 주어진 id 로 찾는다.
        val foundRestaurant = marketRestaurantRepository.findById(givenRestaurantId)

        // null 이 아니어야 한다.
        Assertions.assertThat(foundRestaurant).isNotNull

        // 찾았으면 메뉴 리스트 확인한다.
        // 안 비어있길 바래본다...
        println(foundRestaurant.get().menuList.size)
        Assertions.assertThat(foundRestaurant.get().menuList).isNotEmpty
    }
}
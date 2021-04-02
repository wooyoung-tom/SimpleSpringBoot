package wooyoung.tom.simplespringboot.user

import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.user.dto.MarketUserSigningRequest

@RunWith(SpringRunner::class)
@SpringBootTest
@Transactional
internal open class MarketUserServiceTest {

    @Autowired
    private lateinit var marketUserRepository: MarketUserRepository

    @Test
    fun `회원가입`() {
        // given
        val newUser = MarketUserEntity(
            userName = "test1",
            password = "test"
        )

        // 이름을 통해 존재하는 사용자인지 확인
        val foundUser = marketUserRepository.findMarketUserByUserName(newUser.userName)

        Assertions.assertThat(foundUser).isEqualTo(null)

        // 존재하지 않으면 생성 가능 -> Assert 통과
        val saveResult = marketUserRepository.save(newUser)

        // 넣어준 객체와 ID 같아야 한다.
        Assertions.assertThat(saveResult.id).isEqualTo(newUser.id)
    }

    @Test
    fun `로그인`() {
        val givenUser = MarketUserSigningRequest(
            name = "test",
            password = "test"
        )

        // 이름으로 존재하는 사용자인지 확인
        val foundUser = marketUserRepository.findMarketUserByUserName(givenUser.name)

        Assertions.assertThat(foundUser).isNotNull

    }
}
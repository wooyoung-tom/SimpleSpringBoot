package wooyoung.tom.simplespringboot.user

import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.user.dto.sign_up.MarketUserSignUpRequest

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
            userId = "test1",
            password = "test",
            username = "테스트"
        )

        // 이름을 통해 존재하는 사용자인지 확인
        val foundUser = marketUserRepository.findMarketUserByUserId(newUser.userId)

        Assertions.assertThat(foundUser).isEqualTo(null)

        // 존재하지 않으면 생성 가능 -> Assert 통과
        val saveResult = marketUserRepository.save(newUser)

        // 넣어준 객체와 ID 같아야 한다.
        Assertions.assertThat(saveResult.id).isEqualTo(newUser.id)
    }

    @Test
    fun `로그인`() {
        val givenUser = MarketUserSignUpRequest(
            userId = "test",
            password = "test",
            username = "테스트"
        )

        // 이름으로 존재하는 사용자인지 확인
        val foundUser = marketUserRepository.findMarketUserByUserId(givenUser.userId)

        // 찾은 사용자가 null 이 아니어야 한다.
        Assertions.assertThat(foundUser).isNotNull

        // 비밀번호 확인
        Assertions.assertThat(foundUser?.password).isNotNull
        // null 이 아니면 아래 Assert 는 Not_Null
        Assertions.assertThat(foundUser!!.password).isEqualTo(givenUser.password)
    }
}
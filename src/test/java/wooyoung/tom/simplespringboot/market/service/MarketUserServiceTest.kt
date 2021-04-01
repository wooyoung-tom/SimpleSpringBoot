package wooyoung.tom.simplespringboot.market.service

import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.market.dto.user.MarketUserSignInRequest
import wooyoung.tom.simplespringboot.market.entity.MarketUser
import wooyoung.tom.simplespringboot.market.repository.MarketUserRepository

@SpringBootTest
@RunWith(SpringRunner::class)
@Transactional
internal open class MarketUserServiceTest {

    @Autowired
    private lateinit var marketUserRepository: MarketUserRepository

    @Test
    fun `회원가입`() {
        val newUser = MarketUser(name = "test", password = "test")

        // 중복된 이름 있는지 확인
        val foundResult = marketUserRepository.findMarketUserByName(newUser.name)

        // 회원가입 성공을 위해서는 없어야 한다.
        Assertions.assertThat(foundResult).isEqualTo(null)

        val saveResult = marketUserRepository.save(newUser)

        Assertions.assertThat(saveResult.name).isEqualTo(newUser.name)
    }

    @Test
    fun `이름과 패스워드만 확인하는 간단한 로그인`() {
        val requestUser = MarketUserSignInRequest(name = "test", password = "test")

        // 이름은 고유값이므로 이름으로 유저 찾는다.
        val foundResult = marketUserRepository.findMarketUserByName(requestUser.name)

        // 로그인 성공을 위해서는 유저가 있어야 한다.
        Assertions.assertThat(foundResult != null).isEqualTo(true)

        val checkPassword = requestUser.password == foundResult?.password

        // 로그인 성공을 위해서 패스워드 일치해야 함
        Assertions.assertThat(checkPassword).isEqualTo(true)
    }
}
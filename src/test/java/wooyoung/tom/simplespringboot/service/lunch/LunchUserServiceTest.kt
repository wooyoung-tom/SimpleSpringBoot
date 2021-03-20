package wooyoung.tom.simplespringboot.service.lunch

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.jupiter.api.assertThrows
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.repository.lunch.user.LunchUser

@RunWith(SpringRunner::class)
@SpringBootTest
@Transactional
internal open class LunchUserServiceTest {

    @Autowired
    private lateinit var lunchUserService: LunchUserService

    @Test
    fun `유저 로그인`() {
        val name = "test"
        val result = lunchUserService.signInUser(name)
        assertThat(result.body?.name).isEqualTo(name)
    }

    @Test
    fun `유저 회원가입`() {
        val newUser = LunchUser("new_test", "test_team")

        val result = lunchUserService.signUpUser(newUser)

        assertThat(result.message).isEqualTo("${newUser.name} 등록을 완료하였습니다.")
    }
}
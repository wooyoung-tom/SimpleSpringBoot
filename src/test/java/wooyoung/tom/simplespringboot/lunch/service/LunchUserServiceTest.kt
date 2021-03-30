package wooyoung.tom.simplespringboot.lunch.service

import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.lunch.entity.LunchTeam
import wooyoung.tom.simplespringboot.lunch.entity.LunchUser
import wooyoung.tom.simplespringboot.lunch.repository.LunchTeamRepository
import wooyoung.tom.simplespringboot.lunch.repository.LunchUserRepository

@SpringBootTest
@Transactional
@RunWith(SpringRunner::class)
internal open class LunchUserServiceTest {

    @Autowired
    private lateinit var lunchUserRepository: LunchUserRepository

    @Autowired
    private lateinit var lunchTeamRepository: LunchTeamRepository

    @Test
    fun `회원가입`() {
        // given
        val newTeam = LunchTeam("test_team")
        val newUser = LunchUser("test", newTeam)

        // when
        val teamSaveResult = lunchTeamRepository.save(newTeam)
        val userSaveResult = lunchUserRepository.save(newUser)

        Assertions.assertThat(teamSaveResult.name).isEqualTo("test_team")
    }

    @Test
    fun `로그인`() {
        // given
        val userName = "test"

        // when
        val findUser = lunchUserRepository.findById(userName)

        Assertions.assertThat(findUser.isPresent).isEqualTo(true)

        val foundUser = findUser.get()
        val foundHistory = foundUser.historyList

        Assertions.assertThat(foundHistory.isEmpty()).isEqualTo(false)
    }
}
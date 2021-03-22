package wooyoung.tom.simplespringboot.lunch.repository

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import wooyoung.tom.simplespringboot.lunch.repository.user.LunchUser
import wooyoung.tom.simplespringboot.lunch.repository.user.LunchUserRepository

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
open class LunchUserRepositoryTest {

    // repository Bean 연결
    @Autowired
    private lateinit var repository: LunchUserRepository

    @Test
    fun `유저 등록`() {
        // given
        val newUser = LunchUser("new_test", "test_team")
        // when
        val result = repository.save(newUser)
        // then
        Assertions.assertThat(result.name).isEqualTo(newUser.name)
    }

    @Test
    fun `유저 찾기 by ID`() {
        // given
        val testUser = LunchUser("test", "test_team")
        // when
        val result = repository.findById(testUser.name)
        // then
        Assertions.assertThat(result.isPresent).isEqualTo(true)
    }
}
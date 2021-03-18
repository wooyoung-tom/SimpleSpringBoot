package wooyoung.tom.simplespringboot.repository.lunch.user

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
open class LunchUserRepositoryTest {

    // repository Bean 연결
    @Autowired private var lunchUserRepository: LunchUserRepository? = null

    @Test
    fun USER_INSERT() {
        val user = User()
        user.id = 1
        user.name = "test"

        lunchUserRepository?.save(user)
    }
}
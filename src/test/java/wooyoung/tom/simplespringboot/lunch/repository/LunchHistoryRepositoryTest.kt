package wooyoung.tom.simplespringboot.lunch.repository

import org.assertj.core.api.Assertions
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import wooyoung.tom.simplespringboot.lunch.repository.history.LunchHistory
import wooyoung.tom.simplespringboot.lunch.repository.history.LunchHistoryRepository

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
open class LunchHistoryRepositoryTest {

    @Autowired
    private lateinit var repository: LunchHistoryRepository

    @Test
    fun `어제 먹은 음식의 카테고리 저장`() {
        val history = LunchHistory(
            name = "tom",
            teamName = "Product",
            hDate = "2020-03-21",
            category = "한식"
        )

        val result = repository.save(history)

        Assertions.assertThat(result.id).isEqualTo(history.id)
    }
}
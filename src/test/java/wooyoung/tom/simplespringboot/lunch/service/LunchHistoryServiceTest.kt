package wooyoung.tom.simplespringboot.lunch.service

import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.lunch.repository.history.LunchHistory

@RunWith(SpringRunner::class)
@SpringBootTest
@Transactional
internal open class LunchHistoryServiceTest {

    @Autowired
    private lateinit var lunchHistoryService: LunchHistoryService

    @Test
    fun `히스토리 저장`() {
        val newHistory = LunchHistory(
            name = "tom",
            teamName = "Product",
            date = "2020-03-21",
            category = "한식"
        )
        val result = lunchHistoryService.saveHistory(newHistory)
        Assertions.assertThat(result.body.name).isEqualTo(newHistory.name)
    }
}
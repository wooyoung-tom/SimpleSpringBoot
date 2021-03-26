package wooyoung.tom.simplespringboot.lunch.service

import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.lunch.repository.history.LunchHistory
import wooyoung.tom.simplespringboot.lunch.repository.history.LunchHistoryRepository
import wooyoung.tom.simplespringboot.utils.getYesterdayDateForString

@RunWith(SpringRunner::class)
@SpringBootTest
@Transactional
internal open class LunchHistoryServiceTest {

    @Autowired
    private lateinit var lunchHistoryService: LunchHistoryService
    @Autowired
    private lateinit var lunchHistoryRepository: LunchHistoryRepository

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

    @Test
    fun `팀 이름을 통해 히스토리 리스트를 가져옴`() {
        val teamName = "Product"
        val date = getYesterdayDateForString()

        val result = lunchHistoryRepository.findLunchHistoriesByTeamNameAndDate(teamName, date)

        Assertions.assertThat(result.isEmpty()).isEqualTo(false)
    }

    @Test
    fun `팀 이름과 날짜를 통해 히스토리 리스트를 카테고리 별로 group by`() {
        val teamName = "Product"
        val date = "2021-03-21"

        val result = lunchHistoryRepository.findHistoryCount(
            teamName, date
        )

        result.sortedBy { it.count }

        Assertions.assertThat(result.isEmpty()).isEqualTo(false)
    }
}
package wooyoung.tom.simplespringboot.lunch.service

import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.lunch.entity.LunchHistory
import wooyoung.tom.simplespringboot.lunch.entity.LunchTeam
import wooyoung.tom.simplespringboot.lunch.entity.LunchUser
import wooyoung.tom.simplespringboot.lunch.repository.LunchHistoryRepository
import wooyoung.tom.simplespringboot.lunch.repository.LunchTeamRepository
import wooyoung.tom.simplespringboot.lunch.repository.LunchUserRepository
import java.time.LocalDate
import javax.persistence.EntityManager

@SpringBootTest
@Transactional
@RunWith(SpringRunner::class)
internal open class LunchHistoryServiceTest {

    @Autowired
    private lateinit var lunchHistoryRepository: LunchHistoryRepository

    @Autowired
    private lateinit var lunchUserRepository: LunchUserRepository

    @Autowired
    private lateinit var lunchTeamRepository: LunchTeamRepository

    @Autowired
    private lateinit var entityManager: EntityManager

    @Test
    fun `히스토리 등록`() {
        val newHistory = LunchHistory(
            selectedCategory = "한식",
            selectedDate = LocalDate.now(),
            user = lunchUserRepository.findById("test").get(),
            historyTeam = lunchTeamRepository.findById("test_team").get()
        )
    }

    @Test
    fun `히스토리 종합`() {
        /**
         * 전체 팀원 수 구하는 작업
         */
        // given
        val teamName = "test_team"

        // when
        val foundTeamResult = lunchTeamRepository.findById(teamName)
        val teamMemberCnt = if (foundTeamResult.isPresent) {
            foundTeamResult.get().userList.size
        } else 0

        /**
         * 팀원 중에 고른 사람 수 구하는 작업
         */
        val foundTeamHistoryResult = lunchHistoryRepository
            .findLunchHistoriesByHistoryTeamAndSelectedDate(
                LunchTeam(teamName), LocalDate.now()
            )

        /**
         * 카테고리별 고른 사람 수 구하는 작업
         */
        val foundGroupByCategoryResult = lunchHistoryRepository
            .findLunchHistoriesByHistoryTeamAndSelectedDateGroupBySelectedCategory(
                teamName, LocalDate.now()
            )

        println(foundGroupByCategoryResult[0].getCount())
        println(foundGroupByCategoryResult[0].getCategory())
    }
}
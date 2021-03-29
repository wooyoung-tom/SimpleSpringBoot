package wooyoung.tom.simplespringboot.lunch.service

import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.lunch.entity.LunchHistory
import wooyoung.tom.simplespringboot.lunch.repository.LunchHistoryRepository
import wooyoung.tom.simplespringboot.lunch.repository.LunchUserRepository
import java.time.LocalDate

@SpringBootTest
@Transactional
@RunWith(SpringRunner::class)
internal open class LunchHistoryServiceTest {

    @Autowired
    private lateinit var lunchHistoryRepository: LunchHistoryRepository

    @Autowired
    private lateinit var lunchUserRepository: LunchUserRepository

    @Test
    fun `히스토리 등록`() {
        // given
        val user = lunchUserRepository.findById("test")

        Assertions.assertThat(user.isPresent).isEqualTo(true)

        val newHistory = LunchHistory(user.get(), "한식", LocalDate.now())

        val result = lunchHistoryRepository.save(newHistory)

        Assertions.assertThat(result.user.name).isEqualTo(user.get().name)
    }
}
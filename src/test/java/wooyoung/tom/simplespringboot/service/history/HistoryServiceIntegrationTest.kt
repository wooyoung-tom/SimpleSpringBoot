package wooyoung.tom.simplespringboot.service.history

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.domain.History
import wooyoung.tom.simplespringboot.repository.history.HistoryRepository
import wooyoung.tom.simplespringboot.repository.history.JpaHistoryRepository
import wooyoung.tom.simplespringboot.service.HistoryService

@SpringBootTest
@Transactional
internal open class HistoryServiceIntegrationTest {

    @Autowired val historyService: HistoryService? = null

    @Test
    fun 유저_아이디를_통한_히스토리_검색() {
        // given
        val userId = "test_id"

        // when
        val result = historyService?.getAllHistoryByUserId(userId)

        // then

        // 비어있으면 Assert
        Assertions.assertThat(result.isNullOrEmpty()).isEqualTo(true)
    }

    @Test
    fun saveUserHistory() {
    }
}
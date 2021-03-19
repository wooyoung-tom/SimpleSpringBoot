package wooyoung.tom.simplespringboot.service.sendygo.history

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.service.sendygo.HistoryService

@SpringBootTest
@Transactional
internal open class HistoryServiceTest {

    @Autowired val historyService: HistoryService? = null

    @Test
    fun `유저 아이디를 통한 히스토리 검색`() {
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
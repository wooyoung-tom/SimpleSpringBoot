package wooyoung.tom.simplespringboot.repository.history

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.simple.SimpleJdbcInsert
import org.springframework.stereotype.Repository
import wooyoung.tom.simplespringboot.domain.History
import wooyoung.tom.simplespringboot.dto.HistoryRequestDTO
import java.sql.ResultSet
import javax.sql.DataSource

@Repository
open class JdbcTemplateHistoryRepository(
    private val dataSource: DataSource
) : HistoryRepository {

    private val jdbcTemplate by lazy { JdbcTemplate(dataSource) }

    override fun createHistory(history: HistoryRequestDTO): Long {
        val jdbcInsert = SimpleJdbcInsert(jdbcTemplate)
        jdbcInsert.withTableName("history").usingGeneratedKeyColumns("id")

        val parameters = HashMap<String, Any>()
        parameters["user_id"] = history.userId
        parameters["duration"] = history.duration
        parameters["src_name"] = history.srcName
        parameters["dest_name"] = history.destName
        parameters["distance"] = history.distance
        parameters["credit"] = history.credit
        parameters["history_time"] = history.historyTime
        parameters["history_date"] = history.historyDate

        return jdbcInsert.executeAndReturnKey(MapSqlParameterSource(parameters)).toLong()
    }

    override fun findAllHistoryByUserId(userId: String): List<History> {
        return jdbcTemplate.query(
            "SELECT * FROM history WHERE user_id = ?",
            historyRowMapper,
            userId
        )
    }

    private val historyRowMapper = RowMapper { rs: ResultSet, _: Int ->
        History(
            id = rs.getLong("id"),
            userId = rs.getString("user_id"),
            duration = rs.getString("duration"),
            srcName = rs.getString("src_name"),
            destName = rs.getString("dest_name"),
            distance = rs.getString("distance"),
            credit = rs.getLong("credit"),
            historyTime = rs.getString("history_time"),
            historyDate = rs.getString("history_date")
        )
    }
}
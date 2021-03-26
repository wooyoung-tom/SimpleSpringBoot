package wooyoung.tom.simplespringboot.sendygo.repository.history

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.simple.SimpleJdbcInsert
import wooyoung.tom.simplespringboot.sendygo.dto.HistoryRequest
import java.sql.ResultSet
import javax.sql.DataSource

open class JdbcTemplateSendyGoHistoryRepository(
    private val dataSource: DataSource
) : SendyGoHistoryRepository {

    private val jdbcTemplate by lazy { JdbcTemplate(dataSource) }

    override fun createHistory(history: HistoryRequest): Long {
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

    override fun findAllHistoryByUserId(userId: String): List<SendyGoHistory> {
        return jdbcTemplate.query(
            "SELECT * FROM history WHERE user_id = ?",
            historyRowMapper,
            userId
        )
    }

    private val historyRowMapper = RowMapper { rs: ResultSet, _: Int ->
        SendyGoHistory(
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
package wooyoung.tom.simplespringboot.sendygo.repository.user

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.simple.SimpleJdbcInsert
import org.springframework.stereotype.Repository
import java.sql.ResultSet
import java.util.*
import javax.sql.DataSource
import kotlin.collections.HashMap

@Repository
open class JdbcTemplateSendyGoUserRepository(
    private val dataSource: DataSource
) : SendyGoUserRepository {

    private val jdbcTemplate by lazy { JdbcTemplate(dataSource) }

    override fun create(sendyGoUser: SendyGoUser): SendyGoUser {
        val jdbcInsert = SimpleJdbcInsert(jdbcTemplate)
        jdbcInsert.withTableName("user")

        val parameters = HashMap<String, Any>()
        parameters["id"] = sendyGoUser.id
        parameters["credit"] = sendyGoUser.credit
        parameters["accumulated_credit"] = sendyGoUser.accumulated_credit

        jdbcInsert.execute(MapSqlParameterSource(parameters))

        return sendyGoUser
    }

    override fun findUserById(id: String): Optional<SendyGoUser> {
        val result = jdbcTemplate.query(
            "SELECT * FROM (SELECT *, RANK() OVER (ORDER BY user.credit DESC) as ranking FROM user) SUB WHERE id = ?",
            userRowMapper(),
            id
        )
        return result.stream().findAny()
    }

    override fun findAllUser(): List<SendyGoUser> {
        return jdbcTemplate.query(
            "SELECT * FROM (SELECT *, RANK() OVER (ORDER BY user.credit DESC) as ranking FROM user) SUB ORDER BY ranking ASC",
            userRowMapper()
        )
    }

    override fun updateUserCredit(userId: String, credit: Long): Int {
        return jdbcTemplate.update(
            "UPDATE user SET credit = ?, accumulated_credit = ? WHERE id = ?",
            credit, credit, userId
        )
    }

    private fun userRowMapper(): RowMapper<SendyGoUser> {
        return RowMapper { rs: ResultSet, _: Int ->
            SendyGoUser(
                id = rs.getString("id"),
                credit = rs.getLong("credit"),
                accumulated_credit = rs.getLong("accumulated_credit"),
                rank = rs.getLong("ranking")
            )
        }
    }
}
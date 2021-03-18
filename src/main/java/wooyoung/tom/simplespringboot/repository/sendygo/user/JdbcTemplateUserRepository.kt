package wooyoung.tom.simplespringboot.repository.sendygo.user

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
open class JdbcTemplateUserRepository(
    private val dataSource: DataSource
) : UserRepository {

    private val jdbcTemplate by lazy { JdbcTemplate(dataSource) }

    override fun create(user: User): User {
        val jdbcInsert = SimpleJdbcInsert(jdbcTemplate)
        jdbcInsert.withTableName("user")

        val parameters = HashMap<String, Any>()
        parameters["id"] = user.id
        parameters["credit"] = user.credit
        parameters["accumulated_credit"] = user.accumulated_credit

        jdbcInsert.execute(MapSqlParameterSource(parameters))

        return user
    }

    override fun findUserById(id: String): Optional<User> {
        val result = jdbcTemplate.query(
            "SELECT * FROM (SELECT *, RANK() OVER (ORDER BY user.credit DESC) as ranking FROM user) SUB WHERE id = ?",
            userRowMapper(),
            id
        )
        return result.stream().findAny()
    }

    override fun findAllUser(): List<User> {
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

    private fun userRowMapper(): RowMapper<User> {
        return RowMapper { rs: ResultSet, _: Int ->
            User(
                id = rs.getString("id"),
                credit = rs.getLong("credit"),
                accumulated_credit = rs.getLong("accumulated_credit"),
                rank = rs.getLong("ranking")
            )
        }
    }
}
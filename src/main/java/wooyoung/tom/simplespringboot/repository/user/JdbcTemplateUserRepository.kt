package wooyoung.tom.simplespringboot.repository.user

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.simple.SimpleJdbcInsert
import org.springframework.stereotype.Repository
import wooyoung.tom.simplespringboot.domain.User
import java.sql.ResultSet
import javax.sql.DataSource

@Repository
open class JdbcTemplateUserRepository(
    private val dataSource: DataSource
) : UserRepository {

    private val jdbcTemplate by lazy { JdbcTemplate(dataSource) }

    override fun createUser(userId: String): User {
        val jdbcInsert = SimpleJdbcInsert(jdbcTemplate)
        jdbcInsert.withTableName("user")

        val parameters = HashMap<String, Any>()
        parameters["id"] = userId

        jdbcInsert.execute(MapSqlParameterSource(parameters))

        return User(id = userId)
    }

    override fun findUserById(id: String): User? {
        val result = jdbcTemplate.query(
            "SELECT * FROM (SELECT *, RANK() OVER (ORDER BY user.credit DESC) rank FROM user) WHERE id = ?",
            userRowMapper(),
            id
        )
        return if (result.stream().count() == 0L) null else result.stream().findAny().get()
    }

    override fun findAllUser(): List<User> {
        return jdbcTemplate.query(
            "SELECT * FROM (SELECT *, RANK() OVER (ORDER BY user.credit DESC) rank FROM user)",
            userRowMapper()
        )
    }

    override fun updateUser(user: User): User {
        TODO("Not yet implemented")
    }

    private fun userRowMapper(): RowMapper<User> {
        return RowMapper { rs: ResultSet, _: Int ->
            User(
                id = rs.getString("id"),
                credit = rs.getLong("credit"),
                accumulated_credit = rs.getLong("accumulated_credit"),
                rank = rs.getLong("rank")
            )
        }
    }
}
package wooyoung.tom.simplespringboot.repository.user

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.simple.SimpleJdbcInsert
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.domain.Response
import wooyoung.tom.simplespringboot.domain.User
import java.sql.ResultSet
import javax.sql.DataSource
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

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
            "SELECT * FROM (SELECT *, RANK() OVER (ORDER BY user.credit DESC) rank FROM user) ORDER BY rank ASC",
            userRowMapper()
        )
    }

    @Transactional
    override fun updateUserCredit(userId: String, credit: Long): Int {
        // User 먼저 ID 사용하여 탐색
        val result = findUserById(userId)?.let { foundUser ->
            val updatedCredit = foundUser.credit + credit
            jdbcTemplate.update(
                "UPDATE user SET credit = ?, accumulated_credit = ? WHERE id = ?",
                updatedCredit, updatedCredit, userId
            )
        }

        return result ?: -1
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
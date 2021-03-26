package wooyoung.tom.simplespringboot.sendygo.repository.location

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet
import javax.sql.DataSource

open class JdbcTemplateSendyGoLocationRepository(
    private val dataSource: DataSource
) : SendyGoLocationRepository {

    private val jdbcTemplate by lazy { JdbcTemplate(dataSource) }

    override fun findLocationById(id: Long): SendyGoLocation? {
        val result = jdbcTemplate.query(
            "SELECT * FROM location WHERE id = ?",
            locationRowMapper,
            id
        )

        return if (result.stream().count() == 0L) null else result.stream().findAny().get()
    }

    override fun findAllLocation(): List<SendyGoLocation> {
        return jdbcTemplate.query(
            "SELECT * FROM location",
            locationRowMapper
        )
    }

    private val locationRowMapper = RowMapper { rs: ResultSet, _: Int ->
        SendyGoLocation(
            id = rs.getLong("id"),
            lnglat = rs.getString("lnglat"),
            name = rs.getString("name")
        )
    }

}
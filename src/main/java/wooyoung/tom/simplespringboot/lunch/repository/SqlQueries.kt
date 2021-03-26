package wooyoung.tom.simplespringboot.lunch.repository

object SqlQueries {
    const val findLunchHistoryResultByTeamNameAndDateGroupByCategory =
        "SELECT new wooyoung.tom.simplespringboot.lunch.dto.history.LunchHistoryResult(" +
                "l.category, l.teamName, count(l.category), l.date" +
                ") " +
                "FROM LunchHistory l " +
                "WHERE l.teamName = ?1 AND l.date = ?2 " +
                "GROUP BY l.category"
}
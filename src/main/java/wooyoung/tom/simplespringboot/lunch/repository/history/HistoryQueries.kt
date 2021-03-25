package wooyoung.tom.simplespringboot.lunch.repository.history

object HistoryQueries {
    const val findLunchHistoryResultByTeamNameAndDateGroupByCategory =
        "SELECT new wooyoung.tom.simplespringboot.lunch.dto.history.LunchHistoryResult(" +
                "l.category, l.teamName, count(l.category), l.date" +
                ") " +
                "FROM LunchHistory l, LunchCategory c " +
                "WHERE l.teamName = ?1 AND l.date = ?2 AND l.category = c.name " +
                "GROUP BY l.category"
}
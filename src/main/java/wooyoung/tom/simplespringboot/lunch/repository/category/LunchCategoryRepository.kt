package wooyoung.tom.simplespringboot.lunch.repository.category

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import wooyoung.tom.simplespringboot.lunch.dto.category.CategoryCountResult
import wooyoung.tom.simplespringboot.lunch.repository.SqlQueries

interface LunchCategoryRepository: JpaRepository<LunchCategory, Int> {
}
package wooyoung.tom.simplespringboot.lunch.service

import org.springframework.stereotype.Service
import wooyoung.tom.simplespringboot.lunch.dto.category.CategoryCountResult
import wooyoung.tom.simplespringboot.lunch.repository.category.LunchCategory
import wooyoung.tom.simplespringboot.lunch.repository.category.LunchCategoryRepository
import wooyoung.tom.simplespringboot.utils.getYesterdayDateForString

@Service
open class LunchCategoryService(
    private val lunchCategoryRepository: LunchCategoryRepository
) {

    open fun findAllCategories(): List<LunchCategory> {
        return lunchCategoryRepository.findAll()
    }
}
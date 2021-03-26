package wooyoung.tom.simplespringboot.lunch.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import wooyoung.tom.simplespringboot.lunch.dto.category.CategoryCountResult
import wooyoung.tom.simplespringboot.lunch.repository.category.LunchCategory
import wooyoung.tom.simplespringboot.lunch.service.LunchCategoryService

@RestController
open class LunchCategoryController(
    private val lunchCategoryService: LunchCategoryService
) {

    @GetMapping("/lunch/categories")
    open fun getAllCategories(): List<LunchCategory> {
        return lunchCategoryService.findAllCategories()
    }
}
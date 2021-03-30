package wooyoung.tom.simplespringboot.lunch.entity

interface LunchHistoryGroupBy {

    fun getCount(): Int
    fun getCategory(): String
}
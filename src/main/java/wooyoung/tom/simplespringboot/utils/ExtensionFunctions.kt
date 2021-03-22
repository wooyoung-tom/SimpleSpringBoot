package wooyoung.tom.simplespringboot.utils

import java.text.SimpleDateFormat
import java.util.*

fun getYesterdayDateForString(): String {
    return SimpleDateFormat("yyyy-MM-dd")
        .format(Calendar.getInstance().apply {
            time = Date()
            add(Calendar.DATE, -1)
        }.time).toString()
}
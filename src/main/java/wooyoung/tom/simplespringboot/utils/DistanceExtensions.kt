package wooyoung.tom.simplespringboot.utils

import kotlin.math.*


fun getDistance(lat1: Double, lng1: Double, lat2: Double, lng2: Double): Int {
    val radius = 6371.0     // 지구 반지름 (km)

    val toRadian = Math.PI / 180

    val deltaLatitude = abs(lat1 - lat2) * toRadian
    val deltaLongitude = abs(lng1 - lng2) * toRadian

    val sinDeltaLatitude = sin(deltaLatitude / 2)
    val sinDeltaLongitude = sin(deltaLongitude / 2)

    val squareRoot = sqrt(
        sinDeltaLatitude * sinDeltaLatitude +
                cos(lat1 * toRadian) * cos(lat2 * toRadian) *
                sinDeltaLongitude * sinDeltaLongitude
    )
    return ((2 * radius * asin(squareRoot)) * 1000).toInt()
}
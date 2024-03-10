package com.dongnaoedu.chapter03.util

import java.text.SimpleDateFormat
import java.util.Date

object DateUtil {
    val getNowTime: String
        get() {
            val sdf = SimpleDateFormat("HH:mm:ss")
            return sdf.format(Date())
        }
}

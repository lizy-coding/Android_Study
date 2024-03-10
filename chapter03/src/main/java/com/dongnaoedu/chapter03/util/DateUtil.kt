package com.dongnaoedu.chapter03.util

import java.text.SimpleDateFormat
import java.util.Date

object DateUtil {
    val nowTime: String
        get() {
            val sdf = SimpleDateFormat("HH:mm:ss")
            return sdf.format(Date())
        }
}

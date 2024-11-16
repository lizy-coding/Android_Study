package com.study.chapter04.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date

object DateUtil {
    @JvmStatic
    val nowTime: String
        get() {
            @SuppressLint("SimpleDateFormat") val sdf = SimpleDateFormat("HH:mm:ss")
            return sdf.format(Date())
        }
}

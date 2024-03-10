package com.dongnaoedu.chapter03.util

import android.content.Context

object Utils {
    // 根据手机的分辨率从 dp 的单位 转成为 px(像素)
    fun dip2px(context: Context, dpValue: Float): Int {
        // 获取当前手机的像素密度（1个dp对应几个px）
        val scale = context.resources.displayMetrics.density
        // 四舍五入取整
        return (dpValue * scale + 0.5f).toInt()
    }
}

package com.study.chapter04

import android.content.pm.PackageManager
import android.content.pm.PackageManager.NameNotFoundException
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MetaDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meta_data)
        val tv_meta = findViewById<TextView>(R.id.tv_meta)
        // 获取应用包管理器
        val pm = packageManager
        try {
            // 从应用包管理器中获取当前的活动信息
            val info = pm.getActivityInfo(componentName, PackageManager.GET_META_DATA)
            // 获取活动附加的元数据信息
            val bundle = info.metaData
            val weather = bundle.getString("weather")
            tv_meta.text = weather
        } catch (e: NameNotFoundException) {
            e.printStackTrace()
        }
    }
}
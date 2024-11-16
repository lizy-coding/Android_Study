package com.study.chapter04

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ReadStringActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_string)
        val tv_resource = findViewById<TextView>(R.id.tv_resource)
        // 从strings.xml获取名叫weather_str的字符串值
        val value = getString(R.string.weather_str)
        tv_resource.text = value
    }
}
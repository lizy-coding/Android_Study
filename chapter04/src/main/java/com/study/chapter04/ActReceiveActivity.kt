package com.study.chapter04

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActReceiveActivity : AppCompatActivity() {
    private var textView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_receive)
        textView = findViewById(R.id.tv_receive)
        // 从上一个页面传来的意图中获取快递包裹
        val bundle = intent.extras
        val requestTime = bundle!!.getString("request_time")
        val requestContent = bundle.getString("request_content")
        val desc = String.format(
            "收到请求消息：\n请求时间为%s\n请求内容为%s",
            requestTime,
            requestContent
        )
        textView?.text = desc

    }
}
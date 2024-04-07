package com.study.chapter04

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActReceiveActivity : AppCompatActivity() {
    private var tv_receive: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_receive)
        tv_receive = findViewById(R.id.tv_receive)
        // 从上一个页面传来的意图中获取快递包裹
        val bundle = intent.extras
        val request_time = bundle!!.getString("request_time")
        val request_content = bundle.getString("request_content")
        val desc = String.format(
            "收到请求消息：\n请求时间为%s\n请求内容为%s",
            request_time,
            request_content
        )
        tv_receive.setText(desc)
    }
}
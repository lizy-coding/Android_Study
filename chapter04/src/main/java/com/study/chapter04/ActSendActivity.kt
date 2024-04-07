package com.study.chapter04

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.study.chapter04.util.DateUtil.nowTime

class ActSendActivity : AppCompatActivity(), View.OnClickListener {
    private var tv_send: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_send)
        tv_send = findViewById(R.id.tv_send)
        findViewById<View>(R.id.btn_send).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent = Intent(this, ActReceiveActivity::class.java)
        // 创建一个新包裹
        val bundle = Bundle()
        bundle.putString("request_time", nowTime)
        bundle.putString("request_content", tv_send!!.getText().toString())
        intent.putExtras(bundle)
        startActivity(intent)
    }
}
package com.study.chapter04

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class LoginInputActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_input)
        findViewById<View>(R.id.btn_jump_success).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        // 创建一个意图对象，准备跳到指定的活动页面
        val intent = Intent(this, LoginSuccessActivity::class.java)
        // 设置启动标志：跳转到新页面时，栈中的原有实例都被清空，同时开辟新任务的活动栈
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }
}
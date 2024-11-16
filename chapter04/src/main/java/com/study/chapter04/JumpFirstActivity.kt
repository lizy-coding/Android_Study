package com.study.chapter04

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class JumpFirstActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jump_first)
        findViewById<View>(R.id.btn_jump_second).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        // 创建一个意图对象，准备跳到指定的活动页面
        val intent = Intent(this, JumpSecondActivity::class.java)
        // 栈中存在待跳转的活动实例时，则重新创建该活动的实例，并清除原实例上方的所有实例
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
package com.study.chapter04

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class ActFinishActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_finish)
        findViewById<View>(R.id.iv_back).setOnClickListener(this)
        findViewById<View>(R.id.btn_finish).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.iv_back || v.id == R.id.btn_finish) {
            // 结束当前的活动页面
            finish()
        }
    }
}
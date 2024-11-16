package com.study.chapter04

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class ActionUriActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action_uri)
        findViewById<View>(R.id.btn_dial).setOnClickListener(this)
        findViewById<View>(R.id.btn_sms).setOnClickListener(this)
        findViewById<View>(R.id.btn_my).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent = Intent()
        val phoneNo = "12345"
        when (v.id) {
            R.id.btn_dial -> {
                // 设置意图动作为准备拨号
                intent.setAction(Intent.ACTION_DIAL)
                // 声明一个拨号的Uri
                val uri = Uri.parse("tel:$phoneNo")
                intent.setData(uri)
                startActivity(intent)
            }

            R.id.btn_sms -> {
                // 设置意图动作为发短信
                intent.setAction(Intent.ACTION_SENDTO)
                // 声明一个发送短信的Uri
                val uri2 = Uri.parse("sms to:$phoneNo")
                intent.setData(uri2)
                startActivity(intent)
            }

            R.id.btn_my -> {
                intent.setAction("android.intent.action.NING")
                intent.addCategory(Intent.CATEGORY_DEFAULT)
                startActivity(intent)
            }
        }
    }
}
package com.dongnaoedu.chapter03

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dongnaoedu.chapter03.util.DateUtil

class ButtonEnableActivity : AppCompatActivity(), View.OnClickListener {
    private var btnTest: Button? = null
    private var textView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button_enable)
        val btnEnable = findViewById<Button>(R.id.btn_enable)
        val btnDisable = findViewById<Button>(R.id.btn_disable)
        btnTest = findViewById(R.id.btn_test)
        textView = findViewById(R.id.tv_result)
        btnEnable.setOnClickListener(this)
        btnDisable.setOnClickListener(this)
        btnTest?.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_enable -> {
                // 启用当前控件
                btnTest!!.isEnabled = true
                // 设置按钮的文字颜色
                btnTest!!.setTextColor(Color.BLACK)
            }

            R.id.btn_disable -> {
                // 禁用当前控件
                btnTest!!.isEnabled = false
                btnTest!!.setTextColor(Color.GRAY)
            }

            R.id.btn_test -> {
                val desc =
                    String.format("%s 您点击了按钮： %s", DateUtil.getNowTime, (v as Button).text)
                textView!!.text = desc
            }
        }
    }
}
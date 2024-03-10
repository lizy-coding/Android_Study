package com.dongnaoedu.chapter03

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dongnaoedu.chapter03.util.DateUtil

class ButtonLongClickActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button_long_click)
        val tv_result = findViewById<TextView>(R.id.tv_result)
        val btn_long_click = findViewById<Button>(R.id.btn_long_click)
        btn_long_click.setOnLongClickListener { v: View ->
            val desc =
                String.format("%s 您点击了按钮： %s", DateUtil.getNowTime, (v as Button).text)
            tv_result.text = desc
            true
        }
    }
}
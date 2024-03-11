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
        val textView = findViewById<TextView>(R.id.tv_result)
        val btnLongClick = findViewById<Button>(R.id.btn_long_click)
        btnLongClick.setOnLongClickListener { v: View ->
            val desc =
                String.format("%s 您点击了按钮： %s", DateUtil.getNowTime, (v as Button).text)
            textView.text = desc
            true
        }
    }
}
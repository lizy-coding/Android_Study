package com.dongnaoedu.chapter03

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dongnaoedu.chapter03.util.DateUtil

class ButtonStyleActivity : AppCompatActivity() {
    private var tv_result: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button_style)
        tv_result = findViewById(R.id.tv_result)
    }

    fun doClick(view: View) {
        val desc =
            String.format("%s 您点击了按钮： %s", DateUtil.getNowTime(), (view as Button).text)
        tv_result!!.text = desc
    }
}
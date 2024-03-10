package com.dongnaoedu.chapter03

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dongnaoedu.chapter03.util.DateUtil

class ButtonClickActivity : AppCompatActivity(), View.OnClickListener {
    private var tv_result: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button_click)
        tv_result = findViewById(R.id.tv_result)
        val btn_click_single = findViewById<Button>(R.id.btn_click_single)
        btn_click_single.setOnClickListener(MyOnClickListener(tv_result))
        val btn_click_public = findViewById<Button>(R.id.btn_click_public)
        btn_click_public.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_click_public) {
            val desc =
                String.format("%s 您点击了按钮： %s", DateUtil.getNowTime, (v as Button).text)
            tv_result!!.text = desc
        }
    }

    internal class MyOnClickListener(private val tv_result: TextView?) : View.OnClickListener {
        override fun onClick(v: View) {
            val desc =
                String.format("%s 您点击了按钮： %s", DateUtil.getNowTime, (v as Button).text)
            tv_result!!.text = desc
        }
    }
}
package chapter03

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import chapter03.util.DateUtil
import com.study.chapter03.R

class ButtonClickActivity : AppCompatActivity(), View.OnClickListener {
    private var textView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button_click)
        textView = findViewById(R.id.tv_result)
        val btnClickSingle = findViewById<Button>(R.id.btn_click_single)
        btnClickSingle.setOnClickListener(MyOnClickListener(textView))
        val btnClickPublic = findViewById<Button>(R.id.btn_click_public)
        btnClickPublic.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_click_public) {
            val desc =
                String.format("%s 您点击了按钮： %s", DateUtil.getNowTime, (v as Button).text)
            textView!!.text = desc
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
package chapter03

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import chapter03.util.DateUtil
import com.study.chapter03.R

class ButtonStyleActivity : AppCompatActivity() {
    private var textView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button_style)
        textView = findViewById(R.id.tv_result)
    }

    fun doClick(view: View) {
        val desc =
            String.format("%s 您点击了按钮： %s", DateUtil.getNowTime, (view as Button).text)
        textView!!.text = desc
    }
}
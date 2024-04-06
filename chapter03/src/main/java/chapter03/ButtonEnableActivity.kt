package chapter03

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import chapter03.util.DateUtil
import com.study.chapter03.R

class ButtonEnableActivity : AppCompatActivity(), View.OnClickListener {
    private var btn_test: Button? = null
    private var tv_result: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button_enable)
        val btn_enable = findViewById<Button>(R.id.btn_enable)
        val btn_disable = findViewById<Button>(R.id.btn_disable)
        btn_test = findViewById(R.id.btn_test)
        tv_result = findViewById(R.id.tv_result)
        btn_enable.setOnClickListener(this)
        btn_disable.setOnClickListener(this)
        btn_test?.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_enable -> {
                // 启用当前控件
                btn_test!!.isEnabled = true
                // 设置按钮的文字颜色
                btn_test!!.setTextColor(Color.BLACK)
            }

            R.id.btn_disable -> {
                // 禁用当前控件
                btn_test!!.isEnabled = false
                btn_test!!.setTextColor(Color.GRAY)
            }

            R.id.btn_test -> {
                val desc =
                    String.format("%s 您点击了按钮： %s", DateUtil.getNowTime, (v as Button).text)
                tv_result!!.text = desc
            }
        }
    }
}
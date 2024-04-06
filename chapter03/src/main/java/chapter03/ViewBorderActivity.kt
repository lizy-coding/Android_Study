package chapter03

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dongnaoedu.chapter03.R
import chapter03.util.Utils

class ViewBorderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_border)
        val tv_code = findViewById<TextView>(R.id.tv_code)
        // 获取tv_code的布局参数（含宽度和高度）
        val params = tv_code.layoutParams
        // 修改布局参数中的宽度数值，注意默认px单位，需要把dp数值转成px数值
        params.width = Utils.dip2px(this, 300f)
        // 设置tv_code的布局参数
        tv_code.layoutParams = params
    }
}
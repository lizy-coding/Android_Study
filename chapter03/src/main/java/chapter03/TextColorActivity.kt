package chapter03

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.study.chapter03.R

class TextColorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_color)
        // 从布局文件中获取名叫tv_code_system的文本视图
        val tv_code_system = findViewById<TextView>(R.id.tv_code_system)
        // 将tv_code_system的文字颜色设置系统自带的绿色
        tv_code_system.setTextColor(Color.GREEN)

        // 从布局文件中获取名叫tv_code_eight的文本视图
        val tv_code_eight = findViewById<TextView>(R.id.tv_code_eight)
        // 将tv_code_eight的文字颜色设置为不透明的绿色，即正常的绿色
        tv_code_eight.setTextColor(-0xff0100)

        // 从布局文件中获取名叫tv_code_six的文本视图
        val tv_code_six = findViewById<TextView>(R.id.tv_code_six)
        // 将tv_code_six的文字颜色设置为透明的绿色，透明就是看不到
        tv_code_six.setTextColor(0x00ff00)

        // 从布局文件中获取名叫tv_code_background的文本视图
        val tv_code_background = findViewById<TextView>(R.id.tv_code_background)
        // 将tv_code_background的背景颜色设置为绿色
        //tv_code_background.setBackgroundColor(Color.GREEN);
        // 颜色来源于资源文件
        tv_code_background.setBackgroundResource(R.color.green)
    }
}
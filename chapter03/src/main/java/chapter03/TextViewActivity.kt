package chapter03

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.study.chapter03.R

class TextViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_view)
        val tv_hello = findViewById<TextView>(R.id.tv_hello)
        tv_hello.setText(R.string.hello)
    }
}

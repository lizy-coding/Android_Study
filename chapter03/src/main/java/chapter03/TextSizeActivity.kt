package chapter03

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.study.chapter03.R

class TextSizeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_size)
        val textView = findViewById<TextView>(R.id.tv_px)
        textView.textSize = 30f
    }
}
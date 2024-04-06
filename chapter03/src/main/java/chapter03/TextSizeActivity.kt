package chapter03

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dongnaoedu.chapter03.R

class TextSizeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_size)
        val tv_px = findViewById<TextView>(R.id.tv_px)
        tv_px.textSize = 30f
    }
}
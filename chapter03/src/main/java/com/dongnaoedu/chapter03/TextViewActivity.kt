package com.dongnaoedu.chapter03

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TextViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_view)
        val textView = findViewById<TextView>(R.id.tv_hello)
        textView.setText(R.string.hello)
    }
}

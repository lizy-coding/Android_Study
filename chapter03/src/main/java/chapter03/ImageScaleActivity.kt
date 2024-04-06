package chapter03

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.study.chapter03.R

class ImageScaleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_scale)
        val imageView = findViewById<ImageView>(R.id.iv_scale)
        imageView.setImageResource(R.drawable.apple)
        imageView.scaleType = ImageView.ScaleType.CENTER
    }
}
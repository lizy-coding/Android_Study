package chapter03

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.dongnaoedu.chapter03.R

class ImageScaleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_scale)
        val iv_scale = findViewById<ImageView>(R.id.iv_scale)
        iv_scale.setImageResource(R.drawable.apple)
        iv_scale.scaleType = ImageView.ScaleType.CENTER
    }
}
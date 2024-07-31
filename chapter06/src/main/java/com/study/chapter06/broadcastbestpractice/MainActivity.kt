package com.study.chapter06.broadcastbestpractice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.study.chapter06.broadcastbestpractice.*

class MainActivity : BaseActivity() {

    private lateinit var forceOffline: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        forceOffline = findViewById(R.id.forceOffline)

        forceOffline.setOnClickListener {
            val intent = Intent(ForceOfflineAction)
            sendBroadcast(intent)
        }
    }
}

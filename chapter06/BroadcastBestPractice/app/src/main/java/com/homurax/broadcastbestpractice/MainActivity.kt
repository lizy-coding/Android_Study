package com.homurax.broadcastbestpractice

import android.content.Intent
import android.os.Bundle
import missing.namespace.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    // 声明绑定对象
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 初始化视图绑定
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 使用 ViewBinding 访问 UI 元素
        binding.forceOffline.setOnClickListener {
            val intent = Intent("com.homurax.broadcastbestpractice.FORCE_OFFLINE")
            sendBroadcast(intent)
        }
    }
}

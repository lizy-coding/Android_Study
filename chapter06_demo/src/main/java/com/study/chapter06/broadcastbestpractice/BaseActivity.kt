package com.study.chapter06.broadcastbestpractice

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

//    private lateinit var receiver: ForceOfflineReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 初始化 receiver
//        receiver = ForceOfflineReceiver()
        val filter = IntentFilter().apply {
//            addAction(ForceOfflineAction)
            addAction(Broadcastbestpractice)
        }

        // 注册广播接收器
//        registerReceiver(receiver, filter)
        Log.d("BaseActivity", javaClass.simpleName)
        ActivityCollector.addActivity(this)
    }

    override fun onResume() {
        super.onResume()
        val intentFilter = IntentFilter()
//        intentFilter.addAction(ForceOfflineAction)
//        registerReceiver(ForceOfflineReceiver(), intentFilter, RECEIVER_NOT_EXPORTED)
    }

    override fun onPause() {
        super.onPause()
//        unregisterReceiver(receiver)
    }

    override fun onDestroy() {
        super.onDestroy()
        // 在 onDestroy 方法中解除注册，以防止内存泄漏
//        unregisterReceiver(receiver)
        ActivityCollector.removeActivity(this)
    }



}
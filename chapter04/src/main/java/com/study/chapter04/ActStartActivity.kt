package com.study.chapter04

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class ActStartActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "ActStartActivity onCreate")
        setContentView(R.layout.activity_act_start)
        findViewById<View>(R.id.btn_act_next).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        // 1.在Intent的构造函数中指定
        //Intent intent = new Intent(this, ActFinishActivity.class);
        // 2.调用意图对象的setClass方法指定
        val intent = Intent()
        // intent.setClass(this,ActFinishActivity.class);
        // 3.调用意图对象的setComponent方法指定
        val component = ComponentName(this, ActFinishActivity::class.java)
        intent.setComponent(component)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "ActStartActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "ActStartActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "ActStartActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "ActStartActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "ActStartActivity onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "ActStartActivity onRestart")
    }

    companion object {
        private const val TAG = "aaa"
    }
}
package com.study.chapter04

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.study.chapter04.util.DateUtil.nowTime

class ActRequestActivity : AppCompatActivity(), View.OnClickListener {
    private var register: ActivityResultLauncher<Intent>? = null
    private var tvResponse: TextView? = null
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_request)
        val tvRequest = findViewById<TextView>(R.id.tv_request)
        tvRequest.text = "待发送的消息为：$request"
        tvResponse = findViewById(R.id.tv_response)
        findViewById<View>(R.id.btn_request).setOnClickListener(this)
        register =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult? ->
                if (result != null) {
                    val intent = result.data
                    if (intent != null && result.resultCode == RESULT_OK) {
                        val bundle = intent.extras
                        val responseTime = bundle!!.getString("response_time")
                        val responseContent = bundle.getString("response_content")
                        val desc = String.format(
                            "收到返回消息：\n应答时间为%s\n应答内容为%s",
                            responseTime,
                            responseContent
                        )
                        // 把返回消息的详情显示在文本视图上
                        tvResponse?.text = desc
                    }
                }
            }
    }

    override fun onClick(v: View) {
        val intent = Intent(this, ActResponseActivity::class.java)
        // 创建一个新包裹
        val bundle = Bundle()
        bundle.putString("request_time", nowTime)
        bundle.putString("request_content", request)
        intent.putExtras(bundle)
        register!!.launch(intent)
    }

    companion object {
        private const val request = "在干嘛呢"
    }
}
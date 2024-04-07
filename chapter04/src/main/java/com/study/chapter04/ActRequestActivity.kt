package com.study.chapter04

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import com.study.chapter04.util.DateUtil.nowTime

class ActRequestActivity : AppCompatActivity(), View.OnClickListener {
    private var register: ActivityResultLauncher<Intent>? = null
    private var tv_response: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_request)
        val tv_request = findViewById<TextView>(R.id.tv_request)
        tv_request.text = "待发送的消息为：" + mRequest
        tv_response = findViewById(R.id.tv_response)
        findViewById<View>(R.id.btn_request).setOnClickListener(this)
        register =
            registerForActivityResult<Intent, ActivityResult>(StartActivityForResult()) { result: ActivityResult? ->
                if (result != null) {
                    val intent = result.data
                    if (intent != null && result.resultCode == RESULT_OK) {
                        val bundle = intent.extras
                        val response_time = bundle!!.getString("response_time")
                        val response_content = bundle.getString("response_content")
                        val desc = String.format(
                            "收到返回消息：\n应答时间为%s\n应答内容为%s",
                            response_time,
                            response_content
                        )
                        // 把返回消息的详情显示在文本视图上
                        tv_response.setText(desc)
                    }
                }
            }
    }

    override fun onClick(v: View) {
        val intent = Intent(this, ActResponseActivity::class.java)
        // 创建一个新包裹
        val bundle = Bundle()
        bundle.putString("request_time", nowTime)
        bundle.putString("request_content", mRequest)
        intent.putExtras(bundle)
        register!!.launch(intent)
    }

    companion object {
        private const val mRequest = "你睡了吗？来我家睡吧"
    }
}
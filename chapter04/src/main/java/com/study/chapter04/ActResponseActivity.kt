package com.study.chapter04

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.study.chapter04.util.DateUtil.nowTime

class ActResponseActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_response)
        val tv_request = findViewById<TextView>(R.id.tv_request)
        // 从上一个页面传来的意图中获取快递包裹
        val bundle = intent.extras
        val request_time = bundle!!.getString("request_time")
        val request_content = bundle.getString("request_content")
        val desc = String.format(
            "收到请求消息：\n请求时间为%s\n请求内容为%s",
            request_time,
            request_content
        )
        // 把请求消息的详情显示在文本视图上
        tv_request.text = desc
        findViewById<View>(R.id.btn_response).setOnClickListener(this)
        val tv_response = findViewById<TextView>(R.id.tv_response)
        tv_response.text = "待返回的消息为：" + mReponse
    }

    override fun onClick(v: View) {
        val intent = Intent()
        val bundle = Bundle()
        bundle.putString("response_time", nowTime)
        bundle.putString("response_content", mReponse)
        intent.putExtras(bundle)
        // 携带意图返回上一个页面。RESULT_OK表示处理成功
        setResult(RESULT_OK, intent)
        // 结束当前的活动页面
        finish()
    }

    companion object {
        private const val mReponse = "我还没睡，我爸妈不在家。"
    }
}
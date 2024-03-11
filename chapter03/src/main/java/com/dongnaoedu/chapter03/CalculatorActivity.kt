package com.dongnaoedu.chapter03

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.sqrt

class CalculatorActivity : AppCompatActivity(), View.OnClickListener {
    // 输入框文本
    private var textView: TextView? = null

    // 第一个操作数
    private var firstNum = ""

    // 运算符
    private var operator = ""

    // 第二个操作数
    private var secondNum = ""

    // 当前的计算结果
    private var result = ""

    // 显示的文本内容
    private var showText = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        // 从布局文件中获取名叫tv_result的文本视图
        textView = findViewById(R.id.tv_result)
        // 下面给每个按钮控件都注册了点击监听器
        findViewById<View>(R.id.btn_cancel).setOnClickListener(this)
        findViewById<View>(R.id.btn_divide).setOnClickListener(this) // “除法”按钮
        findViewById<View>(R.id.btn_multiply).setOnClickListener(this) // “乘法”按钮
        findViewById<View>(R.id.btn_clear).setOnClickListener(this) // “清除”按钮
        findViewById<View>(R.id.btn_seven).setOnClickListener(this) // 数字7
        findViewById<View>(R.id.btn_eight).setOnClickListener(this) // 数字8
        findViewById<View>(R.id.btn_nine).setOnClickListener(this) // 数字9
        findViewById<View>(R.id.btn_plus).setOnClickListener(this) // “加法”按钮
        findViewById<View>(R.id.btn_four).setOnClickListener(this) // 数字4
        findViewById<View>(R.id.btn_five).setOnClickListener(this) // 数字5
        findViewById<View>(R.id.btn_six).setOnClickListener(this) // 数字6
        findViewById<View>(R.id.btn_minus).setOnClickListener(this) // “减法”按钮
        findViewById<View>(R.id.btn_one).setOnClickListener(this) // 数字1
        findViewById<View>(R.id.btn_two).setOnClickListener(this) // 数字2
        findViewById<View>(R.id.btn_three).setOnClickListener(this) // 数字3
        findViewById<View>(R.id.btn_reciprocal).setOnClickListener(this) // 求倒数按钮
        findViewById<View>(R.id.btn_zero).setOnClickListener(this) // 数字0
        findViewById<View>(R.id.btn_dot).setOnClickListener(this) // “小数点”按钮
        findViewById<View>(R.id.btn_equal).setOnClickListener(this) // “等号”按钮
        findViewById<View>(R.id.ib_sqrt).setOnClickListener(this) // “开平方”按钮
    }

    override fun onClick(v: View) {
        // 如果是开根号按钮
        val inputText: String = if (v.id == R.id.ib_sqrt) {
            "√"
        } else {
            // 除了开根号之外的其他按钮
            (v as TextView).text.toString()
        }
        when (v.id) {
            R.id.btn_clear -> clear()
            R.id.btn_cancel -> {}
            R.id.btn_plus, R.id.btn_minus, R.id.btn_multiply, R.id.btn_divide -> {
                operator = inputText // 运算符
                refreshText(showText + operator)
            }

            R.id.btn_equal -> {
                // 加减乘除四则运算
                val calculateResult = calculateFour()
                refreshOperate(calculateResult.toString())
                refreshText("$showText=$result")
            }

            R.id.ib_sqrt -> {
                val sqrtResult = sqrt(firstNum.toDouble())
                refreshOperate(sqrtResult.toString())
                refreshText("$showText√=$result")
            }

            R.id.btn_reciprocal -> {
                val reciprocalResult = 1.0 / firstNum.toDouble()
                refreshOperate(reciprocalResult.toString())
                refreshText("$showText/=$result")
            }

            else -> {
                // 上次的运算结果已经出来了
                if (result.isNotEmpty() && operator == "") {
                    clear()
                }

                // 无运算符，则继续拼接第一个操作数
                if (operator == "") {
                    firstNum += inputText
                } else {
                    // 有运算符，则继续拼接第二个操作数
                    secondNum += inputText
                }
                // 整数不需要前面的0
                if (showText == "0" && inputText != ".") {
                    refreshText(inputText)
                } else {
                    refreshText(showText + inputText)
                }
            }
        }
    }

    // 加减乘除四则运算，返回计算结果
    private fun calculateFour(): Double {
        return when (operator) {
            "＋" -> firstNum.toDouble() + secondNum.toDouble()
            "－" -> firstNum.toDouble() - secondNum.toDouble()
            "×" -> firstNum.toDouble() * secondNum.toDouble()
            else -> firstNum.toDouble() / secondNum.toDouble()
        }
    }

    // 清空并初始化
    private fun clear() {
        refreshOperate("")
        refreshText("")
    }

    // 刷新运算结果
    private fun refreshOperate(newResult: String) {
        result = newResult
        firstNum = result
        secondNum = ""
        operator = ""
    }

    // 刷新文本显示
    private fun refreshText(text: String) {
        showText = text
        textView?.text = showText
    }
}
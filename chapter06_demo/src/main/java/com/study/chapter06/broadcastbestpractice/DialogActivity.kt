package com.study.chapter06.broadcastbestpractice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class DialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AlertDialog.Builder(this).apply {
            setTitle("Warning")
            setMessage("You are forced to be offline. Please try to login again.")
            setCancelable(false)
            setPositiveButton("OK") { _, _ ->
                ActivityCollector.finishAll()
                val i = Intent(this@DialogActivity, LoginActivity::class.java)
                startActivity(i)
            }
            show()
        }
    }
}

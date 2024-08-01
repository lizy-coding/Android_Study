package com.study.chapter06.broadcastbestpractice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


const val ForceOfflineAction = "com.study.broadcastbestpractice.FORCE_OFFLINE"

const val Broadcastbestpractice = "com.study.broadcastbestpractice.SEND_MSG"

class ForceOfflineReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent?) {
        when (intent?.action) {
            ForceOfflineAction -> {
                AlertDialog.Builder(context).apply {
                    setTitle("Warning")
                    setMessage("You are forced to be offline. Please try to login again.")
                    setCancelable(false)
                    setPositiveButton("OK") { _, _ ->
                        ActivityCollector.finishAll()
                        val i = Intent(context, LoginActivity::class.java)
                        context.startActivity(i)
                    }
                    show()
                }
            }

            Broadcastbestpractice -> {
                // Handle the SEND_MSG broadcast
                Toast.makeText(context, "Message sent!", Toast.LENGTH_SHORT).show()
            }
        }
    }


}
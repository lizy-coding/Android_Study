package com.study.chapter06.broadcastbestpractice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


//const val ForceOfflineAction = "com.study.broadcastbestpractice.FORCE_OFFLINE"

const val Broadcastbestpractice = "com.study.broadcastbestpractice.SEND_MSG"

class ForceOfflineReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent?) {
        when (intent?.action) {

//            ForceOfflineAction -> {
//                val i = Intent(context, DialogActivity::class.java).apply {
//                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                }
//                context.startActivity(i)
//            }


            Broadcastbestpractice -> {
                // Handle the SEND_MSG broadcast
                Toast.makeText(context, "Message sent!", Toast.LENGTH_SHORT).show()
            }
        }
    }


}
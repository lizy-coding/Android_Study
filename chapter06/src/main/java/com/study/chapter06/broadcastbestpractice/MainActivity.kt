package com.study.chapter06.broadcastbestpractice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.net.DatagramPacket
import java.net.InetAddress
import java.net.MulticastSocket
import kotlin.concurrent.thread

class MainActivity : BaseActivity() {

    private lateinit var forceOffline: Button
    private lateinit var sendMsg: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        forceOffline = findViewById(R.id.forceOffline)
        sendMsg = findViewById(R.id.sendMsg)

        forceOffline.setOnClickListener {
            val intent = Intent(ForceOfflineAction)
            sendBroadcast(intent)
        }

        sendMsg.setOnClickListener {

        }

        sendMsg.setOnClickListener {
            sendMulticastMessage("10.10.101.255", "hello")
            val intent = Intent(Broadcastbestpractice)
            sendBroadcast(intent)
        }
    }

    //    发送组播
    private fun sendMulticastMessage(groupAddress: String, message: String) {
        thread {
            try {
                val socket = MulticastSocket()
                val group = InetAddress.getByName(groupAddress)
                val msgBytes = message.toByteArray()
                val packet = DatagramPacket(msgBytes, msgBytes.size, group, 4446) // 使用 4446 端口

                socket.use {
                    it.send(packet)
                }
                runOnUiThread {
                    Toast.makeText(this, "Message sent to $groupAddress", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                runOnUiThread {
                    Toast.makeText(this, "Failed to send message", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


}

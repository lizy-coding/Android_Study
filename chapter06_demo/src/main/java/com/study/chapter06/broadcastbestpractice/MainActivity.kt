package com.study.chapter06.broadcastbestpractice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import java.net.DatagramPacket
import java.net.InetAddress
import java.net.MulticastSocket
import kotlin.concurrent.thread

class MainActivity : BaseActivity() {

//    private lateinit var forceOffline: Button
    private lateinit var sendMsg: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        forceOffline = findViewById(R.id.forceOffline)
        sendMsg = findViewById(R.id.sendMsg)
//
//        forceOffline.setOnClickListener {
//            val intent = Intent(ForceOfflineAction)
//            sendBroadcast(intent)
//        }



        sendMsg.setOnClickListener {
            sendMulticastMessageHex(
                "10.10.101.255",
                "FF FF FF FF FF FF E0 BE 03 6C 68 FD E0 BE 03 6C 68 FD E0 BE 03 6C 68 FD E0 BE 03 6C 68 FD E0 BE 03 6C 68 FD E0 BE 03 6C 68 FD E0 BE 03 6C 68 FD E0 BE 03 6C 68 FD E0 BE 03 6C 68 FD E0 BE 03 6C 68 FD E0 BE 03 6C 68 FD E0 BE 03 6C 68 FD E0 BE 03 6C 68 FD E0 BE 03 6C 68 FD E0 BE 03 6C 68 FD E0 BE 03 6C 68 FD"
            )
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
                Log.d(
                    "sendMulticastMessage",
                    "groupAddress:$groupAddress,  Sending message: $message"
                )
                val packet = DatagramPacket(msgBytes, msgBytes.size, group, 4343) // 使用 4446 端口

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


    fun sendMulticastMessageHex(groupAddress: String, hexMessage: String) {
        thread {
            try {
                val socket = MulticastSocket()
                val group = InetAddress.getByName(groupAddress)

                // 将十六进制字符串转换为字节数组
                val hexBytes = hexStringToByteArray(hexMessage.replace(" ", ""))

                Log.d("sendMulticastMessage", "groupAddress:$groupAddress, Sending hex message: $hexMessage")
                val packet = DatagramPacket(hexBytes, hexBytes.size, group, 4343) // 使用 4343 端口

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

    // 将十六进制字符串转换为字节数组的函数
    fun hexStringToByteArray(s: String): ByteArray {
        val len = s.length
        val data = ByteArray(len / 2)
        for (i in 0 until len step 2) {
            data[i / 2] = ((Character.digit(s[i], 16) shl 4) + Character.digit(s[i+1], 16)).toByte()
        }
        return data
    }



}

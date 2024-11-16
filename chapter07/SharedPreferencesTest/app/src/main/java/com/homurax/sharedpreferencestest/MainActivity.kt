package com.homurax.sharedpreferencestest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.content.edit

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val saveButton = findViewById<Button>(R.id.saveButton)
        saveButton.setOnClickListener {
            /*// Editor
            val editor = getSharedPreferences("data", Context.MODE_PRIVATE).edit()
            editor.putString("name", "Tom")
            editor.putInt("age", 28)
            editor.putBoolean("married", false)
            // 提交
            editor.apply()*/

            getSharedPreferences("data", Context.MODE_PRIVATE).edit {
                putString("name", "Tom")
                putInt("age", 28)
                putBoolean("married", false)
            }
        }
        val restoreButton = findViewById<Button>(R.id.restoreButton)
        restoreButton.setOnClickListener {
            val prefs = getSharedPreferences("data", Context.MODE_PRIVATE)
            val name = prefs.getString("name", "")
            val age = prefs.getInt("age", 0)
            val married = prefs.getBoolean("married", false)
            Log.d(TAG, "name is $name")
            Log.d(TAG, "age is $age")
            Log.d(TAG, "married is $married")
        }
    }
}

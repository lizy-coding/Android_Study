package com.homurax.broadcastbestpractice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.homurax.broadcastbestpractice.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity() {
    // 声明绑定对象
    private lateinit var binding: ActivityLoginBinding

    private var userVal: String = "admin"
    private var passwordVal: String = "123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 初始化视图绑定
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val prefs = getPreferences(MODE_PRIVATE)
        val isRemember = prefs.getBoolean("remember_password", false)

        if (isRemember) {
            val account = prefs.getString("account", "")
            val password = prefs.getString("password", "")
            // 使用 ViewBinding 访问视图元素
            binding.accountEdit.setText(account)
            binding.passwordEdit.setText(password)
            binding.rememberPass.isChecked = true
        }

        binding.login.setOnClickListener {
            val account = binding.accountEdit.text.toString()
            val password = binding.passwordEdit.text.toString()

            if (account == userVal && password == passwordVal) {
                val editor = prefs.edit()

                if (binding.rememberPass.isChecked) {
                    editor.putBoolean("remember_password", true)
                    editor.putString("account", account)
                    editor.putString("password", password)
                } else {
                    editor.clear()
                }
                Log.d(
                    "LoginActivity",
                    "onCreate: save data, isChecked=${binding.rememberPass.isChecked}"
                )

                editor.apply()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "account or password is invalid", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

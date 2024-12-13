package com.example.activity_intent_tugas

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.activity_intent_tugas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            buttonRegister.setOnClickListener {
                val username = username.text.toString()
                val email = email.text.toString()
                val phone = phone.text.toString()
                val password = password.text.toString()

                if (username.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
                    Toast.makeText(this@MainActivity, "Please fill out all fields", Toast.LENGTH_SHORT).show()
                } else {
                    // Kirim data ke Activity2
                    val intent = Intent(this@MainActivity, MainActivity2::class.java).apply {
                        putExtra("username", username)
                        putExtra("email", email)
                        putExtra("phone", phone)
                        putExtra("password", password)
                    }
                    startActivity(intent)
                }

            }
            visibility.setOnClickListener {
                if (isPasswordVisible) {
                    password.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                    visibility.setImageResource(R.drawable.baseline_visibility_off_24)
                } else {
                    password.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                    visibility.setImageResource(R.drawable.baseline_visibility_off_24)
                }
                isPasswordVisible = !isPasswordVisible
                password.setSelection(password.length())
            }
        }
    }
}

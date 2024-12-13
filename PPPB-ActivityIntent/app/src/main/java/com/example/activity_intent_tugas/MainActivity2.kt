package com.example.activity_intent_tugas

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.activity_intent_tugas.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data dari MainActivity
        val registeredUsername = intent.getStringExtra("username")
        val registeredEmail = intent.getStringExtra("email")
        val registeredPhone = intent.getStringExtra("phone")
        val registeredPassword = intent.getStringExtra("password")

        binding.btnLogin.setOnClickListener {

            val loginUsername = binding.username.text.toString()
            val loginPassword = binding.password.text.toString()

            // Cek apakah data login sesuai dengan data registrasi
            if (loginUsername == registeredUsername && loginPassword == registeredPassword) {
                // Kirim data ke MainActivity3
                val intent = Intent(this@MainActivity2, MainActivity3::class.java).apply {
                    putExtra("username", registeredUsername)
                    putExtra("email", registeredEmail)
                    putExtra("phone", registeredPhone)
                }
                startActivity(intent)
            } else {
                Toast.makeText(
                    this@MainActivity2,
                    "Login failed. Incorrect username or password",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
    }
}

package com.example.activity_intent_tugas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.activity_intent_tugas.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data dari Activity2
        val username = intent.getStringExtra("username")
        val email = intent.getStringExtra("email")
        val phone = intent.getStringExtra("phone")

        // Tampilkan data
        binding.textViewUsername.text = "$username"
        binding.textViewEmail.text = "Email: $email"
        binding.textViewPhone.text = "Phone: $phone"
    }
}

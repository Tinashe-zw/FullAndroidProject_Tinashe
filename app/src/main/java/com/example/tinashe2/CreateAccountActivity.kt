package com.example.tinashe2

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class CreateAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        val loginLink: TextView = findViewById(R.id.loginLink)
        val registerButton: MaterialButton = findViewById(R.id.registerButton)

        registerButton.setOnClickListener {
            // Registration logic
        }

        loginLink.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }
    }
}

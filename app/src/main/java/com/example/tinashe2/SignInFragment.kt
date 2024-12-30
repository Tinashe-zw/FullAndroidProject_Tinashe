package com.example.tinashe2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.button.MaterialButton

class SignInFragment : Fragment() {

    private val credentialsManager = CredentialsManager() // Shared instance of CredentialsManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)

        val emailInputLayout: TextInputLayout = view.findViewById(R.id.emailInputLayout)
        val emailEditText: TextInputEditText = view.findViewById(R.id.emailEditText)
        val passwordInputLayout: TextInputLayout = view.findViewById(R.id.passwordInputLayout)
        val passwordEditText: TextInputEditText = view.findViewById(R.id.passwordEditText)
        val loginButton: MaterialButton = view.findViewById(R.id.loginButton)
        val registerLink: MaterialButton = view.findViewById(R.id.registerLink)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            when {
                email.isEmpty() -> emailInputLayout.error = "Email cannot be empty"
                password.isEmpty() -> passwordInputLayout.error = "Password cannot be empty"
                credentialsManager.login(email, password) -> {
                    Toast.makeText(context, "Login successful!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(context, MainActivity::class.java))
                }
                else -> Toast.makeText(context, "Invalid credentials", Toast.LENGTH_SHORT).show()
            }
        }

        registerLink.setOnClickListener {
            // Switch to CreateAccountFragment
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, CreateAccountFragment())
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}

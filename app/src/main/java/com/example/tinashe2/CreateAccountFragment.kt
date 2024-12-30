package com.example.tinashe2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.button.MaterialButton

class CreateAccountFragment : Fragment() {

    private val credentialsManager = CredentialsManager() // Shared instance of CredentialsManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_create_account, container, false)

        val emailInputLayout: TextInputLayout = view.findViewById(R.id.emailInputLayout)
        val emailEditText: TextInputEditText = view.findViewById(R.id.emailEditText)
        val passwordInputLayout: TextInputLayout = view.findViewById(R.id.passwordInputLayout)
        val passwordEditText: TextInputEditText = view.findViewById(R.id.passwordEditText)
        val registerButton: MaterialButton = view.findViewById(R.id.registerButton)

        registerButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            when {
                email.isEmpty() -> emailInputLayout.error = "Email cannot be empty"
                password.isEmpty() -> passwordInputLayout.error = "Password cannot be empty"
                credentialsManager.register(email, password) -> {
                    Toast.makeText(context, "Registration successful!", Toast.LENGTH_SHORT).show()
                    parentFragmentManager.popBackStack() // Return to SignInFragment
                }
                else -> Toast.makeText(context, "Email is already registered", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}

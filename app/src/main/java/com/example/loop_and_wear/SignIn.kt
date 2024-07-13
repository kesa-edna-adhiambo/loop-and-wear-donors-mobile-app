package com.example.loop_and_wear

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import com.example.loop_and_wear.databinding.ActivitySignInBinding
import com.example.loop_and_wear.databinding.ActivitySignUpBinding

class SignIn : AppCompatActivity() {
    lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set OnClickListener for SignIn button
        binding.etSignUp.setOnClickListener {
            val intent = Intent(this, Sign_up::class.java)
            startActivity(intent)
        }

        // Set OnClickListener for Create Account button
        binding.btSignIn.setOnClickListener {
            validateRegistration()
        }
    }

    fun validateRegistration() {
        var formError = false

        clearErrors()

        val firstName = binding.etUserName.text.toString()
        if (firstName.isBlank()) {
            formError = true
            binding.etUserName.error = "First name is required"
        }

        val lastName = binding.etPassword.text.toString()
        if (lastName.isBlank()) {
            formError = true
            binding.etPassword.error = "Password is required"
        }

        if (!formError) {
            // Navigate to Join As activity if validation passes
            val intent = Intent(this, JoinAs::class.java)
            startActivity(intent)
        }
    }

    private fun Registration(firstName: String, lastName: String, email: String, password: String, confirmPassword: String) {
        // Implementation details
    }

    fun clearErrors() {
        binding.etUserName.error = null
        binding.etPassword.error = null
    }
}

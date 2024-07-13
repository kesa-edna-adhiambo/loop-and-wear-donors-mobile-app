package com.example.loop_and_wear

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loop_and_wear.databinding.ActivitySignUpBinding

class Sign_up : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set OnClickListener for SignIn button
        binding.abSignIn.setOnClickListener {
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }

        // Set OnClickListener for Create Account button
        binding.btCreate.setOnClickListener {
            validateRegistration()
        }
    }

    fun validateRegistration() {
        var formError = false

        clearErrors()

        val firstName = binding.rvName.text.toString()
        if (firstName.isBlank()) {
            formError = true
            binding.rvName.error = "First name is required"
        }

        val lastName = binding.rvLastName.text.toString()
        if (lastName.isBlank()) {
            formError = true
            binding.rvLastName.error = "Last name is required"
        }

        val email = binding.rvEmail.text.toString()
        if (email.isBlank()) {
            formError = true
            binding.rvEmail.error = "Email required"
        }

        val password = binding.rvPassword.text.toString()
        if (password.isBlank()) {
            formError = true
            binding.rvPassword.error = "Password required"
        }

        val confirmPassword = binding.telConfirmPassword.text.toString()
        if (confirmPassword.isBlank()) {
            formError = true
            binding.telConfirmPassword.error = "Password confirmation required"
        }

        if (password != confirmPassword) {
            formError = true
            binding.tvPassword.error = "Passwords do not match"
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
        binding.etFirstName.error = null
        binding.etLastName.error = null
        binding.etEmail.error = null
        binding.etPassword.error = null
        binding.telConfirmPassword.error = null
    }
}
package com.example.loop_and_wear

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loop_and_wear.databinding.ActivitySignUpBinding
import com.example.loop_and_wear.databinding.ActivitySuccessfulDonationBinding

class SuccessfulDonation : AppCompatActivity() {
        private lateinit var binding: ActivitySuccessfulDonationBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivitySuccessfulDonationBinding.inflate(layoutInflater)
            setContentView(binding.root)

            // Set OnClickListener for button4 (to navigate to DropOff activity)
            binding.button4.setOnClickListener {
                val intent = Intent(this, JoinAs::class.java)
                startActivity(intent)
            }

            // Set OnClickListener for button5 (to navigate to HomePage activity)
            binding.button5.setOnClickListener {
                // Assuming you have a function validateForm() that returns a Boolean
                if (validateForm()) {
                    navigateToHomePage()
                } else {
                    // Handle the case where validation fails
                    Toast.makeText(this, "Validation failed", Toast.LENGTH_SHORT).show()
                }
            }
        }

        private fun validateForm(): Boolean {
            // Implement your form validation logic here
            // Return true if validation passes, false otherwise
            return true // Placeholder return value
        }

        private fun navigateToHomePage() {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }
    }
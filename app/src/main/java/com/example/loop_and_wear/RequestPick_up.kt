package com.example.loop_and_wear

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loop_and_wear.databinding.ActivityRequestPickUpBinding
//class RequestPickUp : AppCompatActivity() {
//
//        private lateinit var binding: ActivityRequestPickUpBinding
//
//        override fun onCreate(savedInstanceState: Bundle?) {
//            super.onCreate(savedInstanceState)
//            binding = ActivityRequestPickUpBinding.inflate(layoutInflater)
//            setContentView(binding.root)
//
//            // Initialize checkbox listeners
//            initCheckboxListeners()
//
//            // Example of setting text in an EditText
//            // Replace "Initial Text" with the actual text you want to set
//
//            binding.btPick.setOnClickListener {
//                if (validate()) {
//                    try {
//                        // Explicitly specifying the context to avoid ambiguity
//                        startActivity(Intent(this@RequestPickUp, SuccessfulDonation::class.java))
//                    } catch (e: Exception) {
//                        Log.e("NavigationError", "Failed to start SuccessfulDonation activity", e)
//                        Toast.makeText(this, "Failed to start SuccessfulDonation activity", Toast.LENGTH_LONG).show()
//                    }
//                } else {
//                    Toast.makeText(this, "Form validation failed", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
//
//        private fun initCheckboxListeners() {
//            binding.checkBox5.setOnCheckedChangeListener { _, isChecked ->
//                if (isChecked) {
//                    // Uncheck the other checkboxes
//                    binding.checkBox5.isChecked = true
//                    binding.checkBox.isChecked = false
//                    binding.checkBox6.isChecked = false
//                }
//            }
//
//            binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
//                if (isChecked) {
//                    // Uncheck the other checkboxes
//                    binding.checkBox5.isChecked = false
//                    binding.checkBox.isChecked = true
//                    binding.checkBox6.isChecked = false
//                }
//            }
//
//            binding.checkBox5.setOnCheckedChangeListener { _, isChecked ->
//                if (isChecked) {
//                    // Uncheck the other checkboxes
//                    binding.checkBox.isChecked = false
//                    binding.checkBox6.isChecked = false
//                    binding.checkBox5.isChecked = true
//                }
//            }
//        }
//
//        private fun validate(): Boolean {
//            var formError = false
//
//            clearErrors()
//
//            // Check if at least one checkbox is checked
//            if (!binding.checkBox.isChecked && !binding.checkBox5.isChecked && !binding.checkBox6.isChecked) {
//                formError = true
//                // Display error message for all checkboxes since none is checked
//                binding.checkBox5.error = "At least one option must be selected"
//                binding.checkBox.error = "At least one option must be selected"
//                binding.checkBox6.error = "At least one option must be selected"
//            }
//
//            return !formError
//        }
//
//
//        private fun clearErrors() {
//            binding.checkBox.error = null
//            binding.checkBox5.error = null
//            binding.checkBox6.error = null
//            binding.atpickup.error = null
//        }
//    }

class RequestPickUp : AppCompatActivity() {

    private lateinit var binding: ActivityRequestPickUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRequestPickUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize checkbox listeners
        initCheckboxListeners()

        // Example of setting text in an EditText
        // Replace "Initial Text" with the actual text you want to set

        binding.btPick.setOnClickListener {
            if (validate()) {
                try {
                    // Explicitly specifying the context to avoid ambiguity
                    startActivity(Intent(this@RequestPickUp, SuccessfulDonation::class.java))
                } catch (e: Exception) {
                    Log.e("NavigationError", "Failed to start SuccessfulDonation activity", e)
                    Toast.makeText(this, "Failed to start SuccessfulDonation activity", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Form validation failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initCheckboxListeners() {
        val checkBoxes = listOf(binding.checkBox, binding.checkBox5, binding.checkBox6)
        checkBoxes.forEach { checkBox ->
            checkBox.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    // Uncheck the other checkboxes
                    checkBoxes.filter { it != checkBox }.forEach { otherCheckBox ->
                        otherCheckBox.isChecked = false
                    }
                }
            }
        }
    }

    private fun validate(): Boolean {
        var formError = false

        clearErrors()

        // Validate rvPick
        if (binding.rvpick.text.toString().isEmpty()) {
            formError = true
            binding.rvpick.error = "Pick-up details are required."
        }

        // Check if at least one checkbox is checked
        if (!binding.checkBox.isChecked && !binding.checkBox5.isChecked && !binding.checkBox6.isChecked) {
            formError = true
            // Display error message for all checkboxes since none is checked
            binding.checkBox5.error = "At least one option must be selected"
            binding.checkBox.error = "At least one option must be selected"
            binding.checkBox6.error = "At least one option must be selected"
        }

        return !formError
    }

    private fun clearErrors() {
        binding.checkBox.error = null
        binding.checkBox5.error = null
        binding.checkBox6.error = null
        binding.rvpick.error = null
    }
}


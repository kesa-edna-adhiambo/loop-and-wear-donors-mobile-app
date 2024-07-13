package com.example.loop_and_wear

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loop_and_wear.databinding.ActivityRequestPickUpBinding


class RequestPickUp : AppCompatActivity() {

    private lateinit var binding: ActivityRequestPickUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRequestPickUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize checkbox listeners
        initCheckboxListeners()

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
        binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                uncheckOthers(binding.checkBox)
            }
        }

        binding.checkBox5.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                uncheckOthers(binding.checkBox5)
            }
        }

        binding.checkBox6.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                uncheckOthers(binding.checkBox6)
            }
        }
    }

    private fun uncheckOthers(selectedCheckBox: View) {
        binding.checkBox.isChecked = false
        binding.checkBox5.isChecked = false
        binding.checkBox6.isChecked = false

    }

    private fun validate(): Boolean {
        var formError = false

        clearErrors()

        // Check if at least one checkbox is checked
        if (!binding.checkBox.isChecked && !binding.checkBox5.isChecked && !binding.checkBox6.isChecked) {
            formError = true
            showValidationError()
        }

        // Make the date field required
        val date = binding.rvpick.text.toString()
        if (date.isBlank()) {
            formError = true
            showValidationError()
        }

        return !formError
    }

    private fun showValidationError() {
        binding.checkBox.error = "At least one option must be selected"
        binding.checkBox5.error = "At least one option must be selected"
        binding.checkBox6.error = "At least one option must be selected"
        binding.rvpick.error = "Date is required"
    }

    private fun clearErrors() {
        binding.checkBox.error = null
        binding.checkBox5.error = null
        binding.checkBox6.error = null
        binding.rvpick.error = null
    }
}
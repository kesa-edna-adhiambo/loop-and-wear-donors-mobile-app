package com.example.loop_and_wear

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loop_and_wear.databinding.ActivityDropOffBinding

//class DropOff : AppCompatActivity() {
//    private lateinit var binding: ActivityDropOffBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityDropOffBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        // Initialize checkbox listeners
//        initCheckboxListeners()
//        binding.btNext.setOnClickListener {
//            if (validate()) {
//                startActivity(Intent(this@DropOff, RequestPickUp::class.java))
//            } else {
//                Toast.makeText(this, "At least one option must be selected", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//    private fun initCheckboxListeners() {
//        binding.checkBox2.setOnCheckedChangeListener { _, isChecked ->
//            if (isChecked) {
//                // Uncheck the other checkboxes
//                binding.checkBox2.isChecked = true
//                binding.checkBox3.isChecked = false
//                binding.checkBox4.isChecked = false
//            }
//        }
//        binding.checkBox3.setOnCheckedChangeListener { _, isChecked ->
//            if (isChecked) {
//                // Uncheck the other checkboxes
//                binding.checkBox2.isChecked = false
//                binding.checkBox3.isChecked = true
//                binding.checkBox4.isChecked = false
//            }
//        }
//        binding.checkBox4.setOnCheckedChangeListener { _, isChecked ->
//            if (isChecked) {
//                // Uncheck the other checkboxes
//                binding.checkBox2.isChecked = false
//                binding.checkBox3.isChecked = false
//                binding.checkBox4.isChecked = true
//            }
//        }
//    }
//    private fun validate(): Boolean {
//        var formError = false
//        clearErrors()
//        // Check if at least one checkbox is checked
//        if (!binding.checkBox2.isChecked && !binding.checkBox3.isChecked && !binding.checkBox4.isChecked) {
//            formError = true
//            // Display error message for all checkboxes since none is checked
//            binding.checkBox2.error = "At least one option must be selected"
//            binding.checkBox3.error = "At least one option must be selected"
//            binding.checkBox4.error = "At least one option must be selected"
//        }
//        return !formError
//    }
//    private fun clearErrors() {
//        // Clear errors for checkboxes
//        binding.checkBox2.error = null
//        binding.checkBox3.error = null
//        binding.checkBox4.error = null
//    }
//}
class DropOff : AppCompatActivity() {
    private lateinit var binding: ActivityDropOffBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDropOffBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize checkbox listeners
        initCheckboxListeners()

        binding.btNext.setOnClickListener {
            if (validate()) {
                startActivity(Intent(this@DropOff, RequestPickUp::class.java))
            } else {
                Toast.makeText(this, "Please correct the errors.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initCheckboxListeners() {
        val checkBoxes = listOf(binding.checkBox2, binding.checkBox3, binding.checkBox4)
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

        // Validate rvPhone
        if (binding.rvPhone.text.toString().isEmpty()) {
            formError = true
            binding.rvPhone.error = "Phone number is required."
        }

        // Check if at least one checkbox is checked
        if (!binding.checkBox2.isChecked && !binding.checkBox3.isChecked && !binding.checkBox4.isChecked) {
            formError = true
            // Display error message for all checkboxes since none is checked
            binding.checkBox2.error = "At least one option must be selected"
            binding.checkBox3.error = "At least one option must be selected"
            binding.checkBox4.error = "At least one option must be selected"
        }

        return !formError
    }

    private fun clearErrors() {
        // Clear errors for checkboxes and rvPhone
        binding.checkBox2.error = null
        binding.checkBox3.error = null
        binding.checkBox4.error = null
        binding.rvPhone.error = null
    }
}




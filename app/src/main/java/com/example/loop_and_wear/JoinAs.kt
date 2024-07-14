package com.example.loop_and_wear

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Toast
import com.example.loop_and_wear.databinding.ActivityJoinAsBinding

class JoinAs : AppCompatActivity() {

    private lateinit var binding: ActivityJoinAsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinAsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize checkbox listeners
        initCheckboxListeners()

        binding.button6.setOnClickListener {
            validateCheckboxes()
        }
    }

    private fun initCheckboxListeners() {
        binding.checkBox7.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.checkBox8.isChecked = false
            }
        }

        binding.checkBox8.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.checkBox7.isChecked = false
            }
        }
    }

    private fun validateCheckboxes() {
        val formError = !binding.checkBox7.isChecked && !binding.checkBox8.isChecked
        if (formError) {
            Toast.makeText(this, "Please select at least one option.", Toast.LENGTH_SHORT).show()
        } else {
            startActivity(Intent(this, HomePage::class.java))
        }
    }
}
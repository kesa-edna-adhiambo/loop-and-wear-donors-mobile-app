package com.example.loop_and_wear

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Toast
import com.example.loop_and_wear.databinding.ActivityJoinAsBinding

class JoinAs : AppCompatActivity() {

    lateinit var binding: ActivityJoinAsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinAsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize checkbox listeners
        initCheckboxListeners()

        binding.button6.setOnClickListener {
            startActivity(Intent(this, HomePage::class.java))
        }
    }

    private fun initCheckboxListeners() {
        binding.checkBox7.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Uncheck the other checkbox
                binding.checkBox8.isChecked = false
            }
        }

        binding.checkBox8.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Uncheck the other checkbox
                binding.checkBox7.isChecked = false
            }
        }
    }

    fun validate() {
        var formError = false

        clearErrors()

        // Check if either checkBox7 or checkBox8 is checked

    }

    fun clearErrors() {
        binding.checkBox7.error = null
        binding.checkBox8.error = null
    }
}
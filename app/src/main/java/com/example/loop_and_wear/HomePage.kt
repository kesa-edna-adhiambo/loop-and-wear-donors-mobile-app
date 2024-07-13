package com.example.loop_and_wear

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loop_and_wear.databinding.ActivityHomePageBinding
import com.example.loop_and_wear.databinding.ActivityJoinAsBinding

class HomePage : AppCompatActivity() {
    lateinit var binding: ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLets.setOnClickListener {
            startActivity(Intent(this, DropOff::class.java))
        }

    }
}
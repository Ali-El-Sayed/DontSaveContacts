package com.example.dontsavecontacts

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.dontsavecontacts.databinding.ActivityMainBinding

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this)[ContactViewModel::class.java]

        binding.btSubmit.setOnClickListener {
            viewModel.onCountryCodeChanged(binding.etCountryCode.text.toString().trim())
            viewModel.onPhoneNumberChanged(binding.etPhoneNumber.text.toString().trim())

            startActivity(Api.setContact(viewModel).call())
        }


    }
}
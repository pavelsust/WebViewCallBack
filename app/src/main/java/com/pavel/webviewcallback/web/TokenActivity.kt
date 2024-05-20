package com.pavel.webviewcallback.web

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.pavel.webviewcallback.R
import com.pavel.webviewcallback.databinding.ActivityTokenBinding

const val EXTRA_TOKEN = "extra_token"

class TokenActivity : AppCompatActivity() {

    private val TAG = "CustomWebViewClient"

    private lateinit var _binding: ActivityTokenBinding
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityTokenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonSubmit.setOnClickListener {
            if (binding.editToken.text.toString().isNotEmpty()){
                var intent = Intent(this , WebActivity::class.java)
                intent.putExtra(EXTRA_TOKEN , "${binding.editToken.text.toString()}")
                startActivity(intent)
            }
        }

    }
}
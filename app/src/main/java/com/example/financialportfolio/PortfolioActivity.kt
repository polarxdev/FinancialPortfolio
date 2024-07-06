package com.example.financialportfolio

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.financialportfolio.databinding.ActivityPortfolioBinding

class PortfolioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPortfolioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPortfolioBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_portfolio)

        binding.comebackButton.setOnClickListener{
            onBackPressed()
        }
    }
}
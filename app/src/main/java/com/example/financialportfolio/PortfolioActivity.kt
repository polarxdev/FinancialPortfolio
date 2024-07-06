package com.example.financialportfolio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.financialportfolio.databinding.ActivityPortfolioBinding

class PortfolioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPortfolioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPortfolioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.portfolioComeback.setOnClickListener{
            onBackPressed()
        }
    }
}
package com.example.financialportfolio

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.financialportfolio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            setOnClickListenerForElement(button, AssetsList::class.java)
            setOnClickListenerForElement(button2, PortfolioActivity::class.java)
            setOnClickListenerForElement(button3, SettingsActivity::class.java)
        }
    }

    fun <T> setOnClickListenerForElement(element: View, activity: Class<T>){
        element.setOnClickListener{
            val intent = Intent(this, activity)
            startActivity(intent)
        }
    }
}
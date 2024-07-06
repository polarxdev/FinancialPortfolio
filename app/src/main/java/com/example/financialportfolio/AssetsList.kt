package com.example.financialportfolio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.financialportfolio.databinding.ActivityAssetsListBinding

class AssetsList : AppCompatActivity() {

    private lateinit var bindind: ActivityAssetsListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindind = ActivityAssetsListBinding.inflate(layoutInflater)
        setContentView(bindind.root)

        bindind.listComeback.setOnClickListener{
            onBackPressed()
        }
    }
}
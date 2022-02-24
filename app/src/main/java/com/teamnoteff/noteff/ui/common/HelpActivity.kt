package com.teamnoteff.noteff.ui.common

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.teamnoteff.noteff.databinding.ActivityHelpBinding

class HelpActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHelpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHelpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "App Settings"
        this.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
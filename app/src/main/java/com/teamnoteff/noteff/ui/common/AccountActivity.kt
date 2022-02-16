package com.teamnoteff.noteff.ui.common

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.teamnoteff.noteff.R

class AccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        title = "Account Details"
        this.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
package com.teamnoteff.noteff.ui.common

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.teamnoteff.noteff.databinding.ActivityAppSettingsBinding

class AppSettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppSettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppSettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "App Settings"
        this.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.btnReset1.setOnClickListener {
            showResetAlert()
        }
    }

    private fun showResetAlert(){
        val alertBuilder = AlertDialog.Builder(this)

        alertBuilder.setTitle("Are you sure ?")
        alertBuilder.setMessage("Your account and all the data will be permanently deleted.Are you sure want to continue?")

        alertBuilder.setPositiveButton("Accept", DialogInterface.OnClickListener{ dialog, id ->
            Log.d("dialoglog", "Accept Pressed")
        }).setNegativeButton("Decline", DialogInterface.OnClickListener{ dialog, id ->
            Log.d("dialoglog", "Decline Pressed")
        })
        alertBuilder.create().show()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
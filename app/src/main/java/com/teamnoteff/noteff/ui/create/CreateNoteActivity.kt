package com.teamnoteff.noteff.ui.create

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.teamnoteff.noteff.R


class CreateNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_note)

        title = "Create a new note"
        this.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
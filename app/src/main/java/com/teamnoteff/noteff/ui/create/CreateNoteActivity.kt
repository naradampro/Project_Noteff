package com.teamnoteff.noteff.ui.create

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.db.NoteffDatabase
import com.teamnoteff.noteff.repositories.NoteCreationRepository


class CreateNoteActivity : AppCompatActivity() {

    private lateinit var mainViewModel: CreateNoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_note)

        title = "Create a new note"
        this.supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val dbInstance = NoteffDatabase.getInstance(application)

        val factory = CreateNoteViewModelFactory(NoteCreationRepository(
            dbInstance.noteDao,
            dbInstance.noteCategoryDao,
            dbInstance.plainTextDataSegmentDao,
            dbInstance.importantTextDataSegmentDao,
            dbInstance.phoneNumberDataSegmentDao,
            dbInstance.linkDataSegmentDao,
            dbInstance.imageDataSegmentDao,
        ))

        mainViewModel = ViewModelProvider(this,factory)[CreateNoteViewModel::class.java]
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
package com.teamnoteff.noteff.ui.updateview

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.ActivityUpdateViewBinding
import com.teamnoteff.noteff.db.NoteffDatabase
import com.teamnoteff.noteff.entities.DataSegment
import com.teamnoteff.noteff.repositories.NoteViewUpdateRepository

class UpdateViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateViewBinding
    private lateinit var mainViewModel: UpdateViewViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding= ActivityUpdateViewBinding.inflate(layoutInflater)


        //taking note id in
        val noteId = intent.extras!!.getInt("noteId")

        val dbInstance = NoteffDatabase.getInstance(application)

        val factory = UpdateViewViewModelFactory(NoteViewUpdateRepository(
            dbInstance.noteDao,
            dbInstance.noteCategoryDao,
            dbInstance.plainTextDataSegmentDao,
            dbInstance.importantTextDataSegmentDao,
            dbInstance.phoneNumberDataSegmentDao,
            dbInstance.linkDataSegmentDao,
            dbInstance.imageDataSegmentDao,
        ),noteId
        )

        mainViewModel = ViewModelProvider(this,factory)[UpdateViewViewModel::class.java]

        mainViewModel.setDSList()

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(binding.fcvView.id,ViewFragment.newInstance())
                .commit()
        }

        title = "View Note"

        //defining the toggle switch logic
        setToggleSwitch()
        binding.toggleButton.check(R.id.btnView)
        setContentView(binding.root)
    }

    private fun setToggleSwitch() {
        binding.toggleButton.addOnButtonCheckedListener { _, checkedId, isChecked ->
            if (isChecked) {
                when (checkedId) {
                    R.id.btnView ->{
                        title = "View Note"
                        binding.fcvView.visibility = View.VISIBLE
                        binding.fcvModify.visibility = View.GONE
                    }

                    R.id.btnModify ->{
                        title = "Modify Note"
                        binding.fcvView.visibility = View.GONE
                        binding.fcvModify.visibility = View.VISIBLE
                    }
                }
            }

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
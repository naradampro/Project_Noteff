package com.teamnoteff.noteff.ui.updateview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.ActivityUpdateViewBinding
import com.teamnoteff.noteff.db.NoteffDatabase
import com.teamnoteff.noteff.repositories.NoteViewUpdateRepository

class UpdateViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateViewBinding
    private lateinit var mainViewModel: UpdateViewViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "View Note"
        //taking note id in
        val noteId = intent.extras!!.getInt("noteId")

        binding= ActivityUpdateViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toggleButton.check(R.id.btnView)

        binding.toggleButton.addOnButtonCheckedListener { _, checkedId, isChecked ->
            if (isChecked) {
                when (checkedId) {
                    R.id.btnView ->{
                        if (savedInstanceState == null) {
                            title = "View Note"
                            supportFragmentManager
                                .beginTransaction()
                                .replace(R.id.fcv_view_modify,ViewFragment.newInstance())
                                .commit()
                        }
                    }
                    R.id.btnModify ->{
                        title = "Modify Note"
                        if (savedInstanceState == null) {
                            supportFragmentManager
                                .beginTransaction()
                                .replace(R.id.fcv_view_modify,ModifyOrRemoveFragment.newInstance())
                                .commit()
                        }
                    }
                }
            }
        }

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
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
package com.teamnoteff.noteff.ui.updateview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.ActivityUpdateViewBinding
import com.teamnoteff.noteff.db.NoteffDatabase
import com.teamnoteff.noteff.repositories.NoteCreationRepository
import com.teamnoteff.noteff.repositories.NoteViewUpdateRepository
import com.teamnoteff.noteff.ui.create.CreateNoteViewModelFactory

class UpdateViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateViewBinding
    private lateinit var mainViewModel: UpdateViewViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "View Note"
        this.supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //taking note id in
        val noteId = intent.extras!!.getInt("noteId")
        println(noteId)

        setContentView(R.layout.activity_update_view)
        binding= ActivityUpdateViewBinding.inflate(layoutInflater)

            //Toggle group logics to select the  view or modify page
            binding.toggleButton.addOnButtonCheckedListener { _, checkedId, isChecked ->
                if (isChecked) {
                    when (checkedId) {
                        R.id.btnView ->  {
                            Navigation.findNavController(this,R.id.fcv_view_modify).navigate(R.id.action_modifyOrRemoveFragment_to_viewFragment)
                        }

                        R.id.btnModify -> {
                            Navigation.findNavController(this,R.id.fcv_view_modify).navigate(R.id.action_viewFragment_to_modifyOrRemoveFragment)
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
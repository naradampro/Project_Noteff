package com.teamnoteff.noteff.ui.common

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.HomeFragmentBinding
import com.teamnoteff.noteff.db.NoteffDatabase
import com.teamnoteff.noteff.entities.Note
import com.teamnoteff.noteff.repositories.NoteRepository
import com.teamnoteff.noteff.ui.create.CreateNoteActivity
import com.teamnoteff.noteff.ui.recycler_adapters.HomeNoteListAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var binding: HomeFragmentBinding
    private lateinit var viewModel: HomeViewModel
    private lateinit var noteadapter: HomeNoteListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding=DataBindingUtil.inflate(inflater,R.layout.home_fragment,container,false)

        val btnAddNote: ImageButton = binding.floatingActionButton

        btnAddNote.setOnClickListener{
            val intent = Intent(activity, CreateNoteActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //createSampleNotes()
        val dao = NoteffDatabase.getInstance(requireActivity().application).noteDao

        val factory = HomeViewModelFactory(NoteRepository(dao))

        viewModel = ViewModelProvider(this,factory)[HomeViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteadapter = HomeNoteListAdapter()
        initRecentNotesList()
        //testNoteQuery()
    }

    private fun initRecentNotesList(){

        binding.recentNotesList.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(context)
            // set the custom adapter to the RecyclerView
            this.adapter = noteadapter
        }

        displayRecentNotesList()

        //Checking Recycler Adapter with sample note objects
        /*val sampleNotes: List<Note> = listOf(
            Note(1,"Note 01","Note one display test."),
            Note(2,"Note 02","Note two display test."),
            Note(3,"Note 03","Note three display test."),
            Note(4,"Note 04","Note four display test.")
        )

        noteadapter.setList(sampleNotes)*/

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayRecentNotesList() {
        viewModel.allNotes.observe(viewLifecycleOwner, {
            noteadapter.setList(it)
            noteadapter.notifyDataSetChanged()
        })
    }

    @Suppress("unused")
    private fun createSampleNotes(){
        val noteDao = NoteffDatabase.getInstance(requireActivity().application).noteDao

        lifecycleScope.launch(Dispatchers.IO) {
            noteDao.insertNote(Note(1,"Note 01","Note one display test."))
            noteDao.insertNote(Note(2,"Note 02","Note two display test."))
            noteDao.insertNote(Note(3,"Note 03","Note three display test."))
        }
    }

    @Suppress("unused")
    private fun testNoteQuery(){
        viewModel.allNotes.observe(viewLifecycleOwner){ notes ->
            for (note in notes){
                Log.i("","${note.id}\t${note.title}\t${note.displaytext}")
            }
        }
    }

}
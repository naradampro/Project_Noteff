package com.teamnoteff.noteff.ui.common

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.NotesFragmentBinding
import com.teamnoteff.noteff.db.NoteffDatabase
import com.teamnoteff.noteff.repositories.NoteRepository
import com.teamnoteff.noteff.ui.create.CreateNoteActivity
import com.teamnoteff.noteff.ui.recycler_adapters.ViewAllNotesRecyclerAdapter

class NotesFragment : Fragment() {

    companion object {
        fun newInstance() = NotesFragment()
    }

    private lateinit var viewModel: NotesViewModel
    private lateinit var binding: NotesFragmentBinding
    private lateinit var noteadapter: ViewAllNotesRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= inflate(inflater,R.layout.notes_fragment,container,false)

        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(activity, CreateNoteActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dao = NoteffDatabase.getInstance(requireActivity().application).noteDao

        val factory = NotesViewModelFactory(NoteRepository(dao))

        viewModel = ViewModelProvider(this,factory)[NotesViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteadapter = ViewAllNotesRecyclerAdapter()
        initRecentNotesList()
    }

    private fun initRecentNotesList(){

        binding.allNotesList.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(context)
            // set the custom adapter to the RecyclerView
            this.adapter = noteadapter
        }

        displayRecentNotesList()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayRecentNotesList() {
        viewModel.allNotes.observe(viewLifecycleOwner, {
            noteadapter.setList(it)
            noteadapter.notifyDataSetChanged()
        })
    }

}
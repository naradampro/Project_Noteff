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
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.HomeFragmentBinding
import com.teamnoteff.noteff.db.NoteffDatabase
import com.teamnoteff.noteff.entities.Note
import com.teamnoteff.noteff.repositories.CategoryRepository
import com.teamnoteff.noteff.repositories.NoteRepository
import com.teamnoteff.noteff.ui.create.CreateNoteActivity
import com.teamnoteff.noteff.ui.recycler_adapters.HomeNoteListAdapter
import com.teamnoteff.noteff.ui.recycler_adapters.HomeRecentCategoriesRecyclerAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var binding: HomeFragmentBinding
    private lateinit var viewModel: HomeViewModel
    private lateinit var noteadapter: HomeNoteListAdapter
    private lateinit var categoryadapter: HomeRecentCategoriesRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding=DataBindingUtil.inflate(inflater, R.layout.home_fragment,container,false)

        val btnAddNote: ImageButton = binding.floatingActionButton

        btnAddNote.setOnClickListener{
            val intent = Intent(activity, CreateNoteActivity::class.java)
            startActivity(intent)
        }

        binding.btnViewAllCategories.setOnClickListener{
            findNavController().navigate(R.id.action_navigation_home_to_categories)
        }

        binding.btnViewAllNotes.setOnClickListener{
            findNavController().navigate(R.id.action_navigation_home_to_notes)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //createSampleNotes()
        val noteDao = NoteffDatabase.getInstance(requireActivity().application).noteDao
        val categoryDao = NoteffDatabase.getInstance(requireActivity().application).noteCategoryDao

        val factory = HomeViewModelFactory(NoteRepository(noteDao), CategoryRepository(categoryDao))

        viewModel = ViewModelProvider(this,factory)[HomeViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteadapter = HomeNoteListAdapter(context)
        categoryadapter = HomeRecentCategoriesRecyclerAdapter(context)
        initRecentNotesList()
        //testNoteQuery()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initRecentNotesList(){

        binding.recentNotesList.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(context)
            // set the custom adapter to the RecyclerView
            this.adapter = noteadapter
        }

        binding.recentCategoryList.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = GridLayoutManager(context,2)
            // set the custom adapter to the RecyclerView
            this.adapter = categoryadapter
        }

        displayRecentNotesList()

        viewModel.allCategories.observe(viewLifecycleOwner) {
            categoryadapter.setList(it)
            categoryadapter.notifyDataSetChanged()
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayRecentNotesList() {
        viewModel.allNotes.observe(viewLifecycleOwner) {
            noteadapter.setList(it)
            noteadapter.notifyDataSetChanged()
        }
    }

}
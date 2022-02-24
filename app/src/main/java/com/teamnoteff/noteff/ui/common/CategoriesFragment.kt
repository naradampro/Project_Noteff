package com.teamnoteff.noteff.ui.common

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.CategoriesFragmentBinding
import com.teamnoteff.noteff.db.NoteffDatabase
import com.teamnoteff.noteff.entities.Note
import com.teamnoteff.noteff.entities.NoteCategory
import com.teamnoteff.noteff.repositories.CategoryRepository
import com.teamnoteff.noteff.ui.recycler_adapters.ViewAllCategoriesRecyclerAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoriesFragment : Fragment() {

    companion object {
        fun newInstance() = CategoriesFragment()
    }

    private lateinit var viewModel: CategoriesViewModel
    private lateinit var binding: CategoriesFragmentBinding
    private lateinit var categoriesAdapter: ViewAllCategoriesRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= DataBindingUtil.inflate(inflater,R.layout.categories_fragment,container,false)

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dao = NoteffDatabase.getInstance(requireActivity().application).noteCategoryDao

        val factory = CategoriesViewModelFactory(CategoryRepository(dao))
        //createSampleCategories()

        viewModel = ViewModelProvider(this,factory)[CategoriesViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoriesAdapter = ViewAllCategoriesRecyclerAdapter(requireContext())
        initAllCategoriesList()
    }

    private fun initAllCategoriesList(){

        binding.allCategoriesList.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(context)
            // set the custom adapter to the RecyclerView
            this.adapter = categoriesAdapter
        }

        displayRecentNotesList()
    }

    private fun displayRecentNotesList() {
        viewModel.allCategories.observe(viewLifecycleOwner) {
            categoriesAdapter.setList(it)
        }
    }

    @Suppress("unused")
    private fun createSampleCategories(){
        val dao = NoteffDatabase.getInstance(requireActivity().application).noteCategoryDao

        lifecycleScope.launch(Dispatchers.IO) {
            dao.insertCategory(NoteCategory(1,"Category 01"))
            dao.insertCategory(NoteCategory(2,"Category 02"))
            dao.insertCategory(NoteCategory(3,"Category 03"))
            dao.insertCategory(NoteCategory(4,"Category 04"))
            dao.insertCategory(NoteCategory(5,"Category 05"))
        // dao.deleteAll()
        }
    }

}
package com.teamnoteff.noteff.ui.create

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.teamnoteff.noteff.MainActivity
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.CreateNoteFragmentBinding
import com.teamnoteff.noteff.entities.NoteCategory
import com.teamnoteff.noteff.ui.recycler_adapters.CreateNoteDSRecyclerAdapter


class CreateNoteFragment : Fragment() {

    companion object {
        fun newInstance() = CreateNoteFragment()
    }

    private lateinit var binding: CreateNoteFragmentBinding
    private val mainViewModel: CreateNoteViewModel by activityViewModels()
    private lateinit var dsAdapter: CreateNoteDSRecyclerAdapter
    private lateinit var categoryAdapter: ArrayAdapter<NoteCategory>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= CreateNoteFragmentBinding.inflate(inflater,container,false)

        binding.toggleButton.check(R.id.btnExisting)

        categoryAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_activated_1,
            android.R.id.text1,
        )

        //Toggle group logics to select the note category
        binding.toggleButton.addOnButtonCheckedListener { group, checkedId, isChecked ->
            if (isChecked) {
                when (checkedId) {
                    R.id.btnExisting ->  {
                        binding.textInputLayout.visibility = View.VISIBLE
                        binding.txtLayoutNewCategory.visibility = View.GONE
                    }

                    R.id.btnNew -> {
                        binding.textInputLayout.visibility = View.GONE
                        binding.txtLayoutNewCategory.visibility = View.VISIBLE
                    }

                    R.id.btnUncategorized -> {
                        binding.textInputLayout.visibility = View.GONE
                        binding.txtLayoutNewCategory.visibility = View.GONE
                    }
                }
            } else {
                if (group.checkedButtonId == View.NO_ID) {
                    binding.etNoteTitle.setBackgroundColor(Color.WHITE)
                }
            }
        }

        //opens data segments types list fragments
        binding.btnAddDS.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(R.id.action_createNoteFragment_to_dataSegmentFragment)
        }

        binding.btnCreateNote.setOnClickListener {
            val title = binding.etNoteTitle.text.toString()
            val displaytext = binding.etDisplayText.text.toString()


            when {
                binding.txtLayoutNewCategory.visibility == View.VISIBLE -> {
                    val categoryName = binding.txtNewCategory.text.toString()
                    mainViewModel.saveNoteWithNewCategory(title,displaytext,categoryName)
                }
                binding.textInputLayout.visibility == View.VISIBLE -> {
                    val cat = binding.categorySelectAc.selectedItem as NoteCategory
                    mainViewModel.saveNoteWithExistingCategory(title,displaytext,cat.id)
                }
                else -> {
                    mainViewModel.saveNoteUncategorized(title,displaytext)
                }
            }

            startActivity(Intent(activity, MainActivity::class.java))
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            // Specify the fragment as the lifecycle owner
            lifecycleOwner = viewLifecycleOwner
            // Assign the view model to a property in the binding class
            viewModel = mainViewModel
        }

        setCategoriesToSpinner()

        binding.categorySelectAc.adapter = categoryAdapter

        dsAdapter = CreateNoteDSRecyclerAdapter(mainViewModel,viewLifecycleOwner,parentFragment)

        initDataSegmnetsList()
    }

    private fun initDataSegmnetsList(){
        binding.viewRecyclerview.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(context)
            // set the custom adapter to the RecyclerView
            this.adapter = dsAdapter
        }
        displayDataSegmentList()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun displayDataSegmentList() {
        mainViewModel.datasegments.observe(viewLifecycleOwner) {
            dsAdapter.setList(it)
        }
    }

    //taking category objects to spinner
    private fun setCategoriesToSpinner() {
        mainViewModel.getAllExistingCategories().observe(viewLifecycleOwner){
            categoryAdapter.addAll(it)
        }
    }

}
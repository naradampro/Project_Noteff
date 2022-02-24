package com.teamnoteff.noteff.ui.updateview

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.CreateNoteFragmentBinding
import com.teamnoteff.noteff.entities.NoteCategory
import com.teamnoteff.noteff.ui.create.DataSegmentFragment
import com.teamnoteff.noteff.ui.recycler_adapters.ModifyNoteDSRecyclerAdapter


class ModifyOrRemoveFragment : Fragment() {

    companion object {
        fun newInstance() = ModifyOrRemoveFragment()
    }

    private lateinit var binding: CreateNoteFragmentBinding
    private val mainViewModel: UpdateViewViewModel by activityViewModels()
    private lateinit var dsAdapter: ModifyNoteDSRecyclerAdapter
    private lateinit var categoryAdapter: ArrayAdapter<NoteCategory>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CreateNoteFragmentBinding.inflate(layoutInflater)
        binding.btnCreateNote.text = "SAVE"

        mainViewModel.getNoteById(mainViewModel.getNoteId()).observe(viewLifecycleOwner){note->
            binding.etNoteTitle.setText(note[0].title)
            binding.etDisplayText.setText(note[0].displaytext)
            if(note[0].categoryId==null){
                binding.toggleButton.check(R.id.btnUncategorized)
            }
        }

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

        binding.btnAddDS.setOnClickListener {
            Navigation.findNavController(requireActivity(),R.id.fcv_modify)
                .navigate(R.id.action_modifyOrRemoveFragment_to_dataSegmentMenuFragment)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCategoriesToSpinner()

        binding.categorySelectAc.adapter = categoryAdapter

        dsAdapter = ModifyNoteDSRecyclerAdapter(mainViewModel,viewLifecycleOwner,parentFragment)

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


    fun displayDataSegmentList() {
        mainViewModel.datasegments.observe(viewLifecycleOwner) {
            dsAdapter.setList()
        }
    }

    //taking category objects to spinner
    private fun setCategoriesToSpinner() {
        mainViewModel.getAllExistingCategories().observe(viewLifecycleOwner){
            categoryAdapter.clear()
            categoryAdapter.addAll(it)
        }
    }
}
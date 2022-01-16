package com.teamnoteff.noteff.ui.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.CreateNoteFragmentBinding
import com.teamnoteff.noteff.ui.recycler_adapters.CreateNoteDSRecyclerAdapter
import com.teamnoteff.noteff.ui.recycler_adapters.Records

class CreateNoteFragment : Fragment() {

    companion object {
        fun newInstance() = CreateNoteFragment()
    }

    private lateinit var binding: CreateNoteFragmentBinding
    private val mainViewModel: CreateNoteViewModel by activityViewModels()
    private lateinit var dsAdapter: CreateNoteDSRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= CreateNoteFragmentBinding.inflate(inflater,container,false)

        binding.btnAddDS.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(R.id.action_createNoteFragment_to_dataSegmentFragment)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding?.apply {
            // Specify the fragment as the lifecycle owner
            lifecycleOwner = viewLifecycleOwner
            // Assign the view model to a property in the binding class
            viewModel = mainViewModel
        }
    }

    private fun initRecentNotesList(){

        binding.viewRecyclerview.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(context)
            // set the custom adapter to the RecyclerView
            this.adapter = dsAdapter
        }

    }

}
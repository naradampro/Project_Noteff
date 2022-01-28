package com.teamnoteff.noteff.ui.create

import android.annotation.SuppressLint
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
import com.teamnoteff.noteff.entities.DataSegment
import com.teamnoteff.noteff.entities.ImportantTextDataSegment
import com.teamnoteff.noteff.entities.PhoneNumberDataSegment
import com.teamnoteff.noteff.entities.PlainTextDataSegment
import com.teamnoteff.noteff.ui.recycler_adapters.CreateNoteDSRecyclerAdapter

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
    ): View {
        binding= CreateNoteFragmentBinding.inflate(inflater,container,false)

        binding.btnAddDS.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(R.id.action_createNoteFragment_to_dataSegmentFragment)
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

        dsAdapter = CreateNoteDSRecyclerAdapter()

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
    private fun displayDataSegmentList() {
        /*
        mainViewModel.datasegments.observe(viewLifecycleOwner, {
            dsAdapter.setList(it)
            dsAdapter.notifyDataSetChanged()
        })
        */

        val sampleDSList: List<DataSegment> = listOf(
            ImportantTextDataSegment(1,1,"Sample plain text object"),
            PlainTextDataSegment(1,1,"Sample plain text object"),
            PlainTextDataSegment(1,1,"Sample plain text object"),
            PhoneNumberDataSegment(1,1,"0702093914"),
            ImportantTextDataSegment(1,1,"Sample plain text object"),
            PlainTextDataSegment(1,1,"Sample plain text object"),
            ImportantTextDataSegment(1,1,"Sample plain text object")
        )

        dsAdapter.setList(sampleDSList)
    }

}
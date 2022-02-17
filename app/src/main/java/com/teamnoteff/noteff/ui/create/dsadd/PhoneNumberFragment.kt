package com.teamnoteff.noteff.ui.create.dsadd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.teamnoteff.noteff.databinding.DsaddPhoneNumberFragmentBinding
import com.teamnoteff.noteff.entities.ImportantTextDataSegment
import com.teamnoteff.noteff.entities.PhoneNumberDataSegment
import com.teamnoteff.noteff.entities.PlainTextDataSegment
import com.teamnoteff.noteff.ui.create.CreateNoteFragment
import com.teamnoteff.noteff.ui.create.CreateNoteViewModel

class PhoneNumberFragment : DialogFragment() {

    companion object {
        fun newInstance() = PhoneNumberFragment()
    }

    private val mainViewModel: CreateNoteViewModel by activityViewModels()
    private lateinit var binding: DsaddPhoneNumberFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DsaddPhoneNumberFragmentBinding.inflate(inflater, container, false)

        //the popup does not close when touched outside the popup
        isCancelable = false

        binding.imgBtnClose.setOnClickListener{
            dismiss()
        }

        if(arguments==null){
            binding.btnAdd.setOnClickListener {
                addSegmentToRecyclerView()
            }
        }
        else{
            val index = arguments?.getInt("index")
            val content = arguments?.getString("content").toString()
            binding.etNoteTitle.setText(content)
            binding.btnAdd.text = "Update"
            binding.btnAdd.setOnClickListener {
                updateSegmentToRecyclerView(index!!)
            }
        }

        return binding.root
    }

    private fun addSegmentToRecyclerView(){
        val content = binding.etNoteTitle.text.toString()

        //id and note id should be init later
        val segment = PhoneNumberDataSegment(content)

        mainViewModel.insertDataSegment(segment)

        //invoking the parent fragment's functions to update recycler view
        val ps = requireParentFragment().childFragmentManager?.fragments[0] as CreateNoteFragment
        ps.displayDataSegmentList()

        dismiss()
    }

    private fun updateSegmentToRecyclerView(index:Int){
        val content = binding.etNoteTitle.text.toString()
        mainViewModel.updateDataSegment(index,content)
        //invoking the parent fragment's functions to update recycler view
        val ps = requireParentFragment().childFragmentManager?.fragments[0] as CreateNoteFragment
        ps.displayDataSegmentList()

        dismiss()
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

}
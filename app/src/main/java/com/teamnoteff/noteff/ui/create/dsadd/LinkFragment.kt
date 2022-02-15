package com.teamnoteff.noteff.ui.create.dsadd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.teamnoteff.noteff.databinding.DsaddLinkFragmentBinding
import com.teamnoteff.noteff.entities.ImportantTextDataSegment
import com.teamnoteff.noteff.entities.LinkDataSegment
import com.teamnoteff.noteff.entities.PlainTextDataSegment
import com.teamnoteff.noteff.ui.create.CreateNoteFragment
import com.teamnoteff.noteff.ui.create.CreateNoteViewModel

class LinkFragment : DialogFragment() {

    companion object {
        fun newInstance() = LinkFragment()
    }

    private val mainViewModel: CreateNoteViewModel by activityViewModels()
    private lateinit var binding: DsaddLinkFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DsaddLinkFragmentBinding.inflate(inflater, container, false)

        //the popup does not close when touched outside the popup
        isCancelable = false

        //Closing logic of popup
        binding.imgBtnClose.setOnClickListener{
            dismiss()
        }

        //Link data segment adding logic
        binding.btnAdd.setOnClickListener{
            val content = binding.etNoteTitle.text.toString()

            //id and note id should be init later
            val segment = LinkDataSegment(1,1, content)

            mainViewModel.insertDataSegment(segment)

            //invoking the parent fragment's functions to update recycler view
            val ps = requireParentFragment().childFragmentManager?.fragments[0] as CreateNoteFragment
            ps.displayDataSegmentList()

            dismiss()
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

}
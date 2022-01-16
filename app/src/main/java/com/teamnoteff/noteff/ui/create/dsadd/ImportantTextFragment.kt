package com.teamnoteff.noteff.ui.create.dsadd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.teamnoteff.noteff.databinding.DsaddImportantTextFragmentBinding
import com.teamnoteff.noteff.ui.create.CreateNoteViewModel

class ImportantTextFragment : DialogFragment() {

    companion object {
        fun newInstance() = ImportantTextFragment()
    }

    private val mainViewModel: CreateNoteViewModel by activityViewModels()
    private lateinit var binding: DsaddImportantTextFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DsaddImportantTextFragmentBinding.inflate(inflater, container, false)

        //the popup does not close when touched outside the popup
        isCancelable = false

        binding.imgBtnClose.setOnClickListener{
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
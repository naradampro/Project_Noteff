package com.teamnoteff.noteff.ui.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.DataSegmentFragmentBinding

class DataSegmentFragment : DialogFragment() {

    companion object {
        fun newInstance() = DataSegmentFragment()
    }

    private val mainViewModel: CreateNoteViewModel by activityViewModels()
    private lateinit var binding: DataSegmentFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= DataSegmentFragmentBinding.inflate(inflater, container, false)

        //the popup does not close when touched outside the popup
        isCancelable = true

        //Opens add link popup
        binding.linkButton.setOnClickListener{
            this.dismiss()
            findNavController().navigate(R.id.action_dataSegmentFragment_to_linkFragment)
        }

        //Opens add plain text popup
        binding.plainTextButton.setOnClickListener{
            this.dismiss()
            findNavController().navigate(R.id.action_dataSegmentFragment_to_plainTextFragment)
        }

        //opens add phone number popup
        binding.phoneNumberButton.setOnClickListener{
            this.dismiss()
            findNavController().navigate(R.id.action_dataSegmentFragment_to_phoneNumberFragment)
        }

        //opens add important text popup
        binding.importantButton.setOnClickListener{
            this.dismiss()
            findNavController().navigate(R.id.action_dataSegmentFragment_to_importantTextFragment)
        }

        //to close popup
        binding.imgBtnClose.setOnClickListener{
            dismiss()
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
    }

}
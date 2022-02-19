package com.teamnoteff.noteff.ui.create

import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.DataSegmentFragmentBinding
import com.teamnoteff.noteff.entities.ImageDataSegment
import com.teamnoteff.noteff.entities.PlainTextDataSegment
import dev.ronnie.github.imagepicker.ImagePicker
import dev.ronnie.github.imagepicker.ImageResult

class DataSegmentFragment : DialogFragment() {

    lateinit var imagePicker : ImagePicker

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

        //access to the camera and gallery
        imagePicker = ImagePicker(this)

        //Camera
        binding.takePhotoButton.setOnClickListener {
            imagePicker.takeFromCamera { imageResult ->
                imageCallBack(
                    imageResult
                )
            }
        }

        //Gallery
        binding.uploadImageButton.setOnClickListener {
            imagePicker.pickFromStorage { imageResult ->
                imageCallBack(
                    imageResult
                )
            }
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

    //CallBack for result
    private fun imageCallBack(imageResult: ImageResult<Uri>) {
        when (imageResult) {
            is ImageResult.Success -> {
                val uri = imageResult.value

                //id and note id should be init later
                val segment = ImageDataSegment(uri.toString())

                mainViewModel.insertDataSegment(segment)

                //invoking the parent fragment's functions to update recycler view
                val ps = requireParentFragment().childFragmentManager?.fragments[0] as CreateNoteFragment
                ps.displayDataSegmentList()

                dismiss()
            }
            is ImageResult.Failure -> {
                val errorString = imageResult.errorString
                Toast.makeText(activity, errorString, Toast.LENGTH_LONG).show()
            }
        }
    }

}
package com.teamnoteff.noteff.ui.updateview

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.DataSegmentFragmentBinding
import com.teamnoteff.noteff.entities.ImageDataSegment
import dev.ronnie.github.imagepicker.ImagePicker
import dev.ronnie.github.imagepicker.ImageResult

class DataSegmentMenuFragment : DialogFragment() {

    lateinit var imagePicker : ImagePicker

    companion object {
        fun newInstance() = DataSegmentMenuFragment()
    }

    private val mainViewModel: UpdateViewViewModel by activityViewModels()
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
            Navigation.findNavController(requireActivity(),R.id.fcv_modify)
                .navigate(R.id.action_dataSegmentMenuFragment_to_linkModifyFragment)
        }

        //Opens add plain text popup
        binding.plainTextButton.setOnClickListener{
            this.dismiss()
            Navigation.findNavController(requireActivity(),R.id.fcv_modify)
                .navigate(R.id.action_dataSegmentMenuFragment_to_plainTextModifyFragment)
        }

        //opens add phone number popup
        binding.phoneNumberButton.setOnClickListener{
            this.dismiss()
            Navigation.findNavController(requireActivity(),R.id.fcv_modify)
                .navigate(R.id.action_dataSegmentMenuFragment_to_phoneNumberModifyFragment)
        }

        //opens add important text popup
        binding.importantButton.setOnClickListener{
            this.dismiss()
            Navigation.findNavController(requireActivity(),R.id.fcv_modify)
                .navigate(R.id.action_dataSegmentMenuFragment_to_plainTextModifyFragment)
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
    //CallBack for result
    private fun imageCallBack(imageResult: ImageResult<Uri>) {
        when (imageResult) {
            is ImageResult.Success -> {
                val uri = imageResult.value

                //id and note id should be init later
                val segment = ImageDataSegment(uri.toString())

                mainViewModel.insertDataSegment(segment)

                //invoking the parent fragment's functions to update recycler view
                val ps = requireParentFragment().childFragmentManager?.fragments[0] as UpdateViewActivity
                //ps.displayDataSegmentList()

                dismiss()
            }
            is ImageResult.Failure -> {
                val errorString = imageResult.errorString
                Toast.makeText(activity, errorString, Toast.LENGTH_LONG).show()
            }
        }
    }

}
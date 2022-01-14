package com.teamnoteff.noteff.ui.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.teamnoteff.noteff.R

class DataSegmentFragment : DialogFragment() {

    companion object {
        fun newInstance() = DataSegmentFragment()
    }

    private lateinit var viewModel: DataSegmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.data_segment_fragment, container, false)

        //the popup does not close when touched outside the popup
        isCancelable = false

        val button_link : ImageButton = view.findViewById(R.id.link_button)

        button_link.setOnClickListener{
            this.dismiss()
            findNavController().navigate(R.id.action_dataSegmentFragment_to_linkFragment)
        }

        val button_text_plain : ImageButton = view.findViewById(R.id.plain_text_button)

        button_text_plain.setOnClickListener{
            this.dismiss()
            findNavController().navigate(R.id.action_dataSegmentFragment_to_plainTextFragment)
        }

        val button_phone : ImageButton = view.findViewById(R.id.phone_number_button)

        button_phone.setOnClickListener{
            this.dismiss()
            findNavController().navigate(R.id.action_dataSegmentFragment_to_phoneNumberFragment)
        }

        val button_important : ImageButton = view.findViewById(R.id.important_button)

        button_important.setOnClickListener{
            this.dismiss()
            findNavController().navigate(R.id.action_dataSegmentFragment_to_plainTextFragment)
        }

        //to close popup
        val close: ImageButton = view.findViewById(R.id.imgBtnClose)

        close.setOnClickListener{
            dismiss()
        }

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[DataSegmentViewModel::class.java]
        // TODO: Use the ViewModel
    }

}
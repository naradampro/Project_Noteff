package com.teamnoteff.noteff.ui.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.teamnoteff.noteff.R

class PlainTextFragment : DialogFragment() {

    companion object {
        fun newInstance() = PlainTextFragment()
    }

    private lateinit var viewModel: PlainTextViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.plain_text_fragment, container, false)

        //the popup does not close when touched outside the popup
        isCancelable = false

        //to close popup
        val close: ImageButton = view.findViewById(R.id.imgBtnClose)

        close.setOnClickListener{
            dismiss()
        }

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[PlainTextViewModel::class.java]
        // TODO: Use the ViewModel
    }

}
package com.teamnoteff.noteff.ui.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.teamnoteff.noteff.R

class LinkFragment : DialogFragment() {

    companion object {
        fun newInstance() = LinkFragment()
    }

    private lateinit var viewModel: LinkViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.link_fragment, container, false)

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
        viewModel = ViewModelProvider(this)[LinkViewModel::class.java]
        // TODO: Use the ViewModel
    }

}
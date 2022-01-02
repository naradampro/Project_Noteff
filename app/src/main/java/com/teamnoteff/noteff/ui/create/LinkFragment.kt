package com.teamnoteff.noteff.ui.create

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.DialogFragment
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
        setCancelable(false)

        //to close popup
        val close: ImageButton = view.findViewById(R.id.imgBtnClose)

        close.setOnClickListener{
            dismiss()
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LinkViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
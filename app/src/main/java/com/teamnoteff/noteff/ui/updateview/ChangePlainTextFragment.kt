package com.teamnoteff.noteff.ui.updateview

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.teamnoteff.noteff.R

class ChangePlainTextFragment : Fragment() {

    companion object {
        fun newInstance() = ChangePlainTextFragment()
    }

    private lateinit var viewModel: ChangePlainTextViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.change_plain_text_fragment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[ChangePlainTextViewModel::class.java]
        // TODO: Use the ViewModel
    }

}
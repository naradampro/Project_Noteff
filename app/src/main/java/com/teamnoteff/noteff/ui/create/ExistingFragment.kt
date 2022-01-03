package com.teamnoteff.noteff.ui.create

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.teamnoteff.noteff.R

class ExistingFragment : Fragment() {

    companion object {
        fun newInstance() = ExistingFragment()
    }

    private lateinit var viewModel: ExistingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.existing_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ExistingViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
package com.teamnoteff.noteff.ui.create

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.teamnoteff.noteff.R

class UncategorizedFragment : Fragment() {

    companion object {
        fun newInstance() = UncategorizedFragment()
    }

    private lateinit var viewModel: UncategorizedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.uncategorized_fragment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[UncategorizedViewModel::class.java]
        // TODO: Use the ViewModel
    }

}
package com.teamnoteff.noteff.ui.updateview

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.teamnoteff.noteff.R

class ViewFragment : Fragment() {

    companion object {
        fun newInstance() = ViewFragment()
    }

    private lateinit var viewModel: ViewViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.view_fragment, container, false)

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[ViewViewModel::class.java]
        // TODO: Use the ViewModel
    }

}
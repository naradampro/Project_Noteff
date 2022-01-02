package com.teamnoteff.noteff.ui.updateview

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.teamnoteff.noteff.R

class ModifyOrRemoveFragment : Fragment() {

    companion object {
        fun newInstance() = ModifyOrRemoveFragment()
    }

    private lateinit var viewModel: ModifyOrRemoveViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.modify_or_remove_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ModifyOrRemoveViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
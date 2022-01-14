package com.teamnoteff.noteff.ui.updateview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.teamnoteff.noteff.R

class RemoveDialogFragment : DialogFragment() {

    companion object {
        fun newInstance() = RemoveDialogFragment()
    }

    private lateinit var viewModel: RemoveDialogViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.remove_dialog_fragment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[RemoveDialogViewModel::class.java]
        // TODO: Use the ViewModel
    }

}
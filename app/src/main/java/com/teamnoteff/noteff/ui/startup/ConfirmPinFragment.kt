package com.teamnoteff.noteff.ui.startup

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import com.teamnoteff.noteff.R

class ConfirmPinFragment : Fragment() {

    companion object {
        fun newInstance() = ConfirmPinFragment()
    }

    private lateinit var viewModel: ConfirmPinViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.confirm_pin_fragment, container, false)

        val btnNext: ImageButton = view.findViewById(R.id.btnNext)
        btnNext.setOnClickListener{
            findNavController().navigate(R.id.action_confirmPinFragment_to_createPinFragment)
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ConfirmPinViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
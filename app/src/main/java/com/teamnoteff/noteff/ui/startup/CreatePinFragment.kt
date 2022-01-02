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

class CreatePinFragment : Fragment() {

    companion object {
        fun newInstance() = CreatePinFragment()
    }

    private lateinit var viewModel: CreatePinViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.create_pin_fragment, container, false)

        val btnNext: ImageButton = view.findViewById(R.id.btnNext)
        btnNext.setOnClickListener{
            findNavController().navigate(R.id.action_createPinFragment_to_confirmPinFragment)
        }

        val btnBack: ImageButton = view.findViewById(R.id.btnBack)

        btnNext.setOnClickListener{
            findNavController().navigate(R.id.action_createPinFragment_to_setPasswordFragment)
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CreatePinViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
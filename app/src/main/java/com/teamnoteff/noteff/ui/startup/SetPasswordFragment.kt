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

class SetPasswordFragment : Fragment() {

    companion object {
        fun newInstance() = SetPasswordFragment()
    }

    private lateinit var viewModel: SetPasswordViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.set_password_fragment, container, false)

        val btnNext: ImageButton = view.findViewById(R.id.btnNext)
        btnNext.setOnClickListener{
            findNavController().navigate(R.id.action_setPasswordFragment_to_createPinFragment)
        }

        val btnBack: ImageButton = view.findViewById(R.id.btnBack)

        btnBack.setOnClickListener{
            findNavController().navigate(R.id.action_setPasswordFragment_to_welcomeFragment)
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SetPasswordViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
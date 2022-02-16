package com.teamnoteff.noteff.ui.common

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import com.teamnoteff.noteff.R

class AccountFragment : Fragment() {

    companion object {
        fun newInstance() = AccountFragment()
    }

    private lateinit var viewModel: AccountViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.account_fragment, container, false)

        val btnChangePassword: Button = view.findViewById(R.id.btnChangePassword)
        btnChangePassword.setOnClickListener{
            findNavController().navigate(R.id.action_accountFragment_to_changePasswordFragment)
        }

        val btnChangePin: Button = view.findViewById(R.id.btnChangePin)

        btnChangePin.setOnClickListener{
            findNavController().navigate(R.id.action_accountFragment_to_changePinFragment)
        }

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[AccountViewModel::class.java]
        // TODO: Use the ViewModel
    }

}
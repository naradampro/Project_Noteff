package com.teamnoteff.noteff.ui.common

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.AccountFragmentBinding

class AccountFragment : Fragment() {

    private lateinit var binding: AccountFragmentBinding
    companion object {
        fun newInstance() = AccountFragment()
    }

    private lateinit var viewModel: AccountViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.account_fragment, container, false)

        binding.btnChangePassword.setOnClickListener{
            findNavController().navigate(R.id.action_accountFragment_to_changePasswordFragment)
        }

        binding.btnChangePin.setOnClickListener{
            findNavController().navigate(R.id.action_accountFragment_to_changePinFragment)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[AccountViewModel::class.java]
        // TODO: Use the ViewModel
    }

}
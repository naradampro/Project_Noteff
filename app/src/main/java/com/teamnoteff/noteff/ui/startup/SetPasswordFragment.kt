package com.teamnoteff.noteff.ui.startup

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.SetPasswordFragmentBinding
import com.teamnoteff.noteff.databinding.WelcomeFragmentBinding
import java.util.regex.Pattern

class SetPasswordFragment : Fragment() {

    private val textPattern = "[A-Za-z]"

    private lateinit var binding: SetPasswordFragmentBinding
    companion object {
        fun newInstance() = SetPasswordFragment()
    }

    //private lateinit var viewModel: SetPasswordViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.set_password_fragment, container, false)

        val viewPager =  activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.btnNext.setOnClickListener {

            //validate confirm password

            val password = binding.etNPwdText.text.toString()
            val confirmpassword = binding.etCNPwdText.text.toString()

            if (password.isEmpty()) {
                binding.etNPwdText.error = "Password Required"
                return@setOnClickListener
            }
            else if(!password.matches(textPattern.toRegex())){
                binding.etNPwdText.error = "Incorrect Password"
            }

            else if (confirmpassword.isEmpty()) {
                binding.etCNPwdText.error = "Password Required"
                return@setOnClickListener
            }
            else if(!confirmpassword.matches(textPattern.toRegex())){
                binding.etCNPwdText.error = "Incorrect Password"
                return@setOnClickListener
            }

            viewPager?.currentItem = 2
        }

        binding.btnBack.setOnClickListener {
            viewPager?.currentItem = 0
        }
        return binding.root
    }
}
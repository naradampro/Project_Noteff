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

    private val passwordCharacters="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\\\\\/%§\"&“|`´}{°><:.;#')(@_\$\"!?*=^-]).{8,}\$"



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




            val password = binding.etNPwdText.text.toString().trim()
            val cPassword = binding.etCNPwdText.text.toString().trim()

            if (password.isEmpty()){
                binding.etNPwdText.error="Password is required"
                return@setOnClickListener
            }

            else if (!password.matches(passwordCharacters.toRegex())){
                binding.etNPwdText.error="Password Characters are not matching"
            }



            if (cPassword.isEmpty()){
                binding.etCNPwdText.error="Confirm your password"
                return@setOnClickListener
            }
            else if (password!=cPassword){
                binding.etCNPwdText.error="Password does not match"
            }






            else{
                viewPager?.currentItem = 2
            }



        }

        binding.btnBack.setOnClickListener {
            viewPager?.currentItem = 0
        }
        return binding.root
    }
}
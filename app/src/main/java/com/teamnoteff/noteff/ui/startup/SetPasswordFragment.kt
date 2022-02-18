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

class SetPasswordFragment : Fragment() {
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


            viewPager?.currentItem = 2
        }

        binding.btnBack.setOnClickListener {
            viewPager?.currentItem = 0
        }
        return binding.root
    }
}
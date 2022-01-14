package com.teamnoteff.noteff.ui.startup

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.ConfirmPinFragmentBinding

class ConfirmPinFragment : Fragment() {
    private lateinit var binding: ConfirmPinFragmentBinding

    companion object {
        fun newInstance() = ConfirmPinFragment()
    }

    private lateinit var viewModel: ConfirmPinViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.confirm_pin_fragment, container, false)

        val viewPager =  activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.btnBack.setOnClickListener {
            viewPager?.currentItem = 2
        }

        binding.btnFinish.setOnClickListener{
            findNavController().navigate(R.id.action_viewPagerFragment_to_mobile_navigation)
            onBoardingFinished()
        }


        return binding.root
    }

    private fun onBoardingFinished(){
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[ConfirmPinViewModel::class.java]
        // TODO: Use the ViewModel
    }

}
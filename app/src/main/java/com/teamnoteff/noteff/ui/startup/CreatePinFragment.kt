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
import com.teamnoteff.noteff.databinding.CreatePinFragmentBinding
import com.teamnoteff.noteff.databinding.FragmentViewPagerBinding

class CreatePinFragment : Fragment() {
    private lateinit var binding: CreatePinFragmentBinding

    companion object {
        fun newInstance() = CreatePinFragment()
    }

    private lateinit var viewModel: CreatePinViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.create_pin_fragment, container, false)

        val viewPager =  activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.btnNext.setOnClickListener {
            viewPager?.currentItem = 3
        }

        binding.btnBack.setOnClickListener {
            viewPager?.currentItem = 1
        }


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[CreatePinViewModel::class.java]
        // TODO: Use the ViewModel
    }

}
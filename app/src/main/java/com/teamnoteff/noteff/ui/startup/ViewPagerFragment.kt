package com.teamnoteff.noteff.ui.startup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.FragmentViewPagerBinding
import com.teamnoteff.noteff.ui.recycler_adapters.ViewPagerAdapter

class ViewPagerFragment : Fragment() {
    private lateinit var binding: FragmentViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_view_pager,container,false)

        val fragmentList = arrayListOf<Fragment>(
            WelcomeFragment(),
            SetPasswordFragment(),
            CreatePinFragment(),
            ConfirmPinFragment()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )
//        val viewPager = activity?.findViewById<ViewPager>(R.id.viewPager)
//        viewPager?.adapter =  adapter
        binding.viewPager.adapter = adapter

        return binding.root

    }
}
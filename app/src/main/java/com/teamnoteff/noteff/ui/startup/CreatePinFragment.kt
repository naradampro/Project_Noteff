package com.teamnoteff.noteff.ui.startup

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.goodiebag.pinview.Pinview
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.CreatePinFragmentBinding
import com.teamnoteff.noteff.databinding.FragmentViewPagerBinding

class CreatePinFragment : Fragment() {
    private lateinit var binding: CreatePinFragmentBinding

    private val pinSize="^[0-9]{4}"




    companion object {
        fun newInstance() = CreatePinFragment()
    }

    //private lateinit var viewModel: CreatePinViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.create_pin_fragment, container, false)

        val viewPager =  activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.btnNext.setOnClickListener {


            val pin=binding.pinView.value.intern().trim()

            if (pin.isEmpty()){
                binding.pinView.hint="empty"
                return@setOnClickListener
            }
            else if (!pin.matches(pinSize.toRegex())){
                binding.pinView.pinBackground
                return@setOnClickListener
            }




            else{
                viewPager?.currentItem = 3
            }




        }

        binding.btnBack.setOnClickListener {
            viewPager?.currentItem = 1
        }

       /* binding.pinView.setPinViewEventListener(object : Pinview.PinViewEventListener {
            override fun onDataEntered(pinview: Pinview?, fromUser: Boolean) {
                Toast.makeText(activity, pinview!!.value, Toast.LENGTH_SHORT).show()
            }
        })*/

        return binding.root
    }
}
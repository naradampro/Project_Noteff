package com.teamnoteff.noteff.ui.startup

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.viewpager2.widget.ViewPager2
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.WelcomeFragmentBinding
import com.teamnoteff.noteff.ui.create.CreateNoteViewModel

class WelcomeFragment : Fragment() {

    private lateinit var binding: WelcomeFragmentBinding

    companion object {
        fun newInstance() = WelcomeFragment()
    }

    //private val mainViewModel: StartUpViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.welcome_fragment,container,false)

        val viewPager =  activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.btnStart.setOnClickListener {
            val fName = binding.etFNameText.text.toString()

            

            viewPager?.currentItem = 1
        }

        return binding.root

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO: Use the ViewModel
    }

}
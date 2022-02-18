package com.teamnoteff.noteff.ui.startup

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.WelcomeFragmentBinding
import com.teamnoteff.noteff.entities.UserConfig

class WelcomeFragment : Fragment() {

    private lateinit var binding: WelcomeFragmentBinding

    companion object {
        fun newInstance() = WelcomeFragment()
    }

    private lateinit var viewModel: WelcomeViewModel

    private fun initUserConfigs(): List<UserConfig> {
        return listOf(
            UserConfig(1,"user_first_name",null),
            UserConfig(2,"user_last_name",null),
            UserConfig(3,"user_email",null),
            UserConfig(4,"user_password_hash",null),
            UserConfig(5,"user_pin_hash",null),
            UserConfig(6,"user_dp_url",null),
            UserConfig(7,"account_theme","system"),
            UserConfig(8,"account_fingerprint_enable","false")
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.welcome_fragment,container,false)

        val viewPager =  activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.btnStart.setOnClickListener {
            viewPager?.currentItem = 1
        }

        return binding.root

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[WelcomeViewModel::class.java]
        // TODO: Use the ViewModel
    }

}
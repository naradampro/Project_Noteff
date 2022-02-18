package com.teamnoteff.noteff.ui.startup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.WelcomeFragmentBinding
import com.teamnoteff.noteff.entities.UserConfig


class WelcomeFragment : Fragment() {

    private lateinit var binding: WelcomeFragmentBinding
    private val emailPattern = "[a-zA-Z0-9._]+@[a-z]+\\.+[a-z]+"
    private val textPattern = "^[A-Za-z]+$"



    companion object {
        fun newInstance() = WelcomeFragment()
    }

    //private val mainViewModel: StartUpViewModel by activityViewModels()

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
            val fName = binding.etFNameText.text.toString().trim()
            val lName = binding.etLNameText.text.toString().trim()
            val email = binding.etEmailText.text.toString().trim()


            if (fName.isEmpty()){
                binding.etFNameText.error="First Name Required"
                return@setOnClickListener
            }
            else if (!fName.matches(textPattern.toRegex())){
                binding.etFNameText.error="Incorrect Name Pattern"
                return@setOnClickListener
            }


            if (lName.isEmpty()){
                binding.etLNameText.error="Last Name Required"
                return@setOnClickListener
            }
            else if (!lName.matches(textPattern.toRegex())){
                binding.etLNameText.error="Incorrect Name Pattern"
                return@setOnClickListener

            }


            if(email.isEmpty()){
                binding.etEmailText.error="Email Required"
                return@setOnClickListener
            }
            else if (!email.matches(emailPattern.toRegex())){
                binding.etEmailText.error="Invalid Email Address"
                return@setOnClickListener
            }



            else{
                viewPager?.currentItem = 1
            }



        }

        return binding.root

    }

}
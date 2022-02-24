package com.teamnoteff.noteff.ui.common

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.CreateNoteFragmentBinding
import com.teamnoteff.noteff.databinding.MenuFragmentBinding

class MenuFragment : BottomSheetDialogFragment() {

    companion object {
        fun newInstance() = MenuFragment()
    }

    private lateinit var viewModel: MenuViewModel
    private lateinit var binding : MenuFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= MenuFragmentBinding.inflate(inflater,container,false)

        binding.btnAppSettings.setOnClickListener{
            this.dismiss()
            findNavController().navigate(R.id.action_navigation_menu_to_appSettingsActivity)
        }

        binding.btnAccount.setOnClickListener{
            this.dismiss()
            findNavController().navigate(R.id.action_navigation_menu_to_accountActivity)
        }

        binding.btnAboutUs.setOnClickListener{
            this.dismiss()
            findNavController().navigate(R.id.action_navigation_menu_to_aboutUsActivity)
        }

        binding.btnHelp.setOnClickListener{
            this.dismiss()
            findNavController().navigate(R.id.action_navigation_menu_to_helpActivity)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MenuViewModel::class.java]
        // TODO: Use the ViewModel
    }

}
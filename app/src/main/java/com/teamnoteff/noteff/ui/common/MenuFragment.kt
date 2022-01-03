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

class MenuFragment : BottomSheetDialogFragment() {

    companion object {
        fun newInstance() = MenuFragment()
    }

    private lateinit var viewModel: MenuViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //setCancelable(false)
        val view = inflater.inflate(R.layout.menu_fragment, container, false)

        val btnAppSettings: ImageButton = view.findViewById(R.id.btnAppSettings)
        btnAppSettings.setOnClickListener{
            findNavController().navigate(R.id.action_navigation_menu_to_appSettingsFragment)
        }

        val btnAccount: ImageButton = view.findViewById(R.id.btnAccount)

        btnAccount.setOnClickListener{
            findNavController().navigate(R.id.action_navigation_menu_to_accountFragment)
        }

        val btnAboutUs: ImageButton = view.findViewById(R.id.btnAboutUs)
        btnAboutUs.setOnClickListener{
            findNavController().navigate(R.id.action_navigation_menu_to_aboutUsFragment)
        }

        val btnHelp: ImageButton = view.findViewById(R.id.btnHelp)

        btnHelp.setOnClickListener{
            findNavController().navigate(R.id.action_navigation_menu_to_helpFragment)
        }

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MenuViewModel::class.java]
        // TODO: Use the ViewModel
    }

}
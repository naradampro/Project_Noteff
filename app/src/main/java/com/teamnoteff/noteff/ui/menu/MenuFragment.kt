package com.teamnoteff.noteff.ui.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.FragmentMenu2Binding


class MenuFragment : BottomSheetDialogFragment() {

    private lateinit var menuViewModel: MenuViewModel
    private var _binding: FragmentMenu2Binding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        menuViewModel =
            ViewModelProvider(this).get(MenuViewModel::class.java)

        _binding = FragmentMenu2Binding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textUName
        menuViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
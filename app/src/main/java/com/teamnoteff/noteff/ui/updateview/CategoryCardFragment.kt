package com.teamnoteff.noteff.ui.updateview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.CategoryCardFragmentBinding


class CategoryCardFragment : Fragment() {
    private lateinit var binding: CategoryCardFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adapter = context?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.drop_down_list, android.R.layout.simple_spinner_item)
        }
        // Specify the layout to use when the list of choices appears
        adapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner

        binding.spinner.adapter = adapter

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.category_card_fragment, container, false)
        return binding.root


    }
}
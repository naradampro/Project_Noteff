package com.teamnoteff.noteff.ui.updateview

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.teamnoteff.noteff.R

class ModifyOrRemoveFragment : Fragment() {

    companion object {
        fun newInstance() = ModifyOrRemoveFragment()
    }

    private lateinit var viewModel: ModifyOrRemoveViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.modify_or_remove_fragment, container, false)

        val btnView : Button = view.findViewById(R.id.btnView)

        btnView.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_modifyOrRemoveFragment_to_viewFragment)
        }

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[ModifyOrRemoveViewModel::class.java]
        // TODO: Use the ViewModel
    }

}
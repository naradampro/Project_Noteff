package com.teamnoteff.noteff.ui.create

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.teamnoteff.noteff.R

class CreateNoteFragment : Fragment() {

    companion object {
        fun newInstance() = CreateNoteFragment()
    }

    private lateinit var viewModel: CreateNoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.create_note_fragment, container, false)

        val buttonAddDS : Button = view.findViewById(R.id.btnAddDS)

        buttonAddDS.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_createNoteFragment_to_dataSegmentFragment)
        }

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[CreateNoteViewModel::class.java]
        // TODO: Use the ViewModel
    }

}
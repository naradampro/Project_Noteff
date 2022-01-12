package com.teamnoteff.noteff.ui.common

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.ui.create.CreateNoteActivity

class NotesFragment : Fragment() {

    companion object {
        fun newInstance() = NotesFragment()
    }

    private lateinit var viewModel: NotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.notes_fragment, container, false)

        val btnAdd : FloatingActionButton = view.findViewById(R.id.floating_action_button)

        btnAdd.setOnClickListener {
            val intent = Intent(activity, CreateNoteActivity::class.java)
            startActivity(intent)
        }

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[NotesViewModel::class.java]
        // TODO: Use the ViewModel
    }

}
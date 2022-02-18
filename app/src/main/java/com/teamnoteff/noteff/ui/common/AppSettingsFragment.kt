package com.teamnoteff.noteff.ui.common

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.teamnoteff.noteff.databinding.AppSettingsFragmentBinding
import com.teamnoteff.noteff.ui.create.CreateNoteFragment

class AppSettingsFragment : Fragment() {
    companion object {
        fun newInstance() = CreateNoteFragment()
    }

    private lateinit var binding: AppSettingsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= AppSettingsFragmentBinding.inflate(inflater,container,false)

        binding.btnReset.setOnClickListener {
            showResetAlert()
        }

        return binding.root
    }

    private fun showResetAlert(){
        val alertBuilder = AlertDialog.Builder(context)

        alertBuilder.setTitle("Are you sure ?")
        alertBuilder.setMessage("Your account and all the data will be permanently deleted.Are you sure want to continue?")

        alertBuilder.setPositiveButton("Accept", DialogInterface.OnClickListener{ dialog, id ->
            Log.d("dialoglog", "Accept Pressed")
        }).setNegativeButton("Decline", DialogInterface.OnClickListener{ dialog, id ->
            Log.d("dialoglog", "Decline Pressed")
        })
        alertBuilder.create().show()
    }

}
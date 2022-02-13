package com.teamnoteff.noteff.ui.common

import android.app.AlertDialog
import android.app.Dialog
import android.app.DialogFragment
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log

class Dialog : DialogFragment(){
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let{
            val alertBuilder = AlertDialog.Builder(it)

            alertBuilder.setTitle("Are you sure ?")
            alertBuilder.setMessage("Your account and all the data will be permanently deleted.Are you sure want to continue?")

            alertBuilder.setPositiveButton("Accept", DialogInterface.OnClickListener{ dialog, id ->
                Log.d("dialoglog", "Accept Pressed")
            }).setNegativeButton("Decline", DialogInterface.OnClickListener{ dialog, id ->
                Log.d("dialoglog", "Decline Pressed")
            })
            alertBuilder.create()
        } ?: throw IllegalStateException("Exception ! Activity is null !")
    }
}
/*Related to AppSettingFragment*/
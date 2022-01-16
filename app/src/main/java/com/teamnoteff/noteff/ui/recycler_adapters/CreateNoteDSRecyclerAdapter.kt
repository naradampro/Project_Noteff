package com.teamnoteff.noteff.ui.recycler_adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.teamnoteff.noteff.R

class CreateNoteDSRecyclerAdapter(private val context: Context, private val listOfNotes: MutableList<Records>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val IMPORTANT_VIEW_TYPE = 1
        const val PLAIN_VIEW_TYPE = 2
    }

    class ImportantViewHolder(private val importantView: View) : RecyclerView.ViewHolder(importantView) {
        var imageView: ImageView = importantView.findViewById(R.id.important_img)
        var textView: TextView = importantView.findViewById(R.id.txtImportant)
    }

    class PlainTextViewHolder(private val plainTextView: View) : RecyclerView.ViewHolder(plainTextView) {
        var plain_text: TextView = plainTextView.findViewById(R.id.txtPlainDisplay)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == IMPORTANT_VIEW_TYPE) {
            return ImportantViewHolder(
                LayoutInflater.from(context).inflate(R.layout.modify_important, parent, false)
            )
        }else {
            return PlainTextViewHolder(
                LayoutInflater.from(context).inflate(R.layout.modify_plain_text, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemData = listOfNotes[position]

        if (itemData.viewType == IMPORTANT_VIEW_TYPE) {
            val importantViewHolder = holder as ImportantViewHolder
            importantViewHolder.textView.text = itemData.text
        }
        else {
            val plainViewHolder = holder as PlainTextViewHolder
            plainViewHolder.plain_text.text = itemData.text
        }
    }

    override fun getItemViewType(position: Int): Int {
        return listOfNotes[position].viewType
    }

    override fun getItemCount(): Int {
        return listOfNotes.size
    }
}

data class Records(val viewType: Int, val text: String)
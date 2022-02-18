package com.teamnoteff.noteff.ui.recycler_adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.NoteCardBinding
import com.teamnoteff.noteff.entities.Note
import java.util.ArrayList

class CategoryNotesRecyclerAdapter : RecyclerView.Adapter<CategoryNotesRecyclerAdapter.ViewHolder>() {
    private lateinit var binding: NoteCardBinding

    private val notesList = ArrayList<Note>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryNotesRecyclerAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.note_card, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryNotesRecyclerAdapter.ViewHolder, position: Int) {
        holder.bind(notesList[position])
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(notes: List<Note>) {
        notesList.clear()
        notesList.addAll(notes)
        notifyDataSetChanged()
    }



    inner class ViewHolder(binding:NoteCardBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            binding.txtTitle.text = note.title
            binding.txtDisplay.text = note.displaytext
        }


    }

}
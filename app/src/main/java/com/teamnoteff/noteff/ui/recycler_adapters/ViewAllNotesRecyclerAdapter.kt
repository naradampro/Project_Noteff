package com.teamnoteff.noteff.ui.recycler_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.NoteCardBinding
import com.teamnoteff.noteff.entities.Note
import java.util.*

class ViewAllNotesRecyclerAdapter:RecyclerView.Adapter<ViewAllNotesRecyclerAdapter.ViewHolder>(){
    private lateinit var binding:NoteCardBinding

    private val recentNotesList = ArrayList<Note>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewAllNotesRecyclerAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.note_card, parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewAllNotesRecyclerAdapter.ViewHolder, position: Int) {
        holder.bind(recentNotesList[position])
    }

    override fun getItemCount(): Int {
        return recentNotesList.size
    }

    fun setList(notes: List<Note>) {
        recentNotesList.clear()
        recentNotesList.addAll(notes)
    }

    inner class ViewHolder(binding:NoteCardBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(note: Note) {
            binding.txtTitle.text = note.title
            binding.txtDisplay.text = note.displaytext
        }
        /*init {
            binding.cardView.setOnClickListener{
                val position: Int = adapterPosition

                Toast.makeText(itemView.context, "You Clicked on ${titles[position]}", Toast.LENGTH_LONG).show()
            }
        }*/

    }


}
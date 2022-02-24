package com.teamnoteff.noteff.ui.recycler_adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.NoteCardBinding
import com.teamnoteff.noteff.entities.Note
import com.teamnoteff.noteff.ui.updateview.UpdateViewActivity
import java.util.*

class ViewAllNotesRecyclerAdapter(private val context: Context?):RecyclerView.Adapter<ViewAllNotesRecyclerAdapter.ViewHolder>(){
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

            binding.root.setOnClickListener{
                val bundle = Bundle()
                bundle.putString("noteId", note.id.toString())
                val intent = Intent(context, UpdateViewActivity::class.java)

                //sending note id to update view activity
                intent.putExtra("noteId",note.id)
                context?.startActivity(intent)
            }
        }

    }


}
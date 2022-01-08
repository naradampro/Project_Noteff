package com.teamnoteff.noteff.ui.recycler_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.NoteCardBinding

class HomeNoteListAdapter:RecyclerView.Adapter<HomeNoteListAdapter.ViewHolder>(){
    private lateinit var binding:NoteCardBinding

    private var titles = arrayOf("Chapter One","Chapter Two","Chapter Three","Chapter Four","Chapter Five","Chapter Six")

    private var details = arrayOf("Item One details","Item Two details","Item Three details","Item Four details","Item Five details","Item Six details")


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeNoteListAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.note_card, parent, false)
        return ViewHolder(binding)
    }



    override fun onBindViewHolder(holder: HomeNoteListAdapter.ViewHolder, position: Int) {
        holder.cardTitle.text = titles[position]
        holder.cardDisplayText.text = details[position]

    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(binding:NoteCardBinding): RecyclerView.ViewHolder(binding.root){
        var cardTitle: TextView = binding.txtTitle
        var cardDisplayText: TextView = binding.txtDisplay

        /*init {
            binding.cardView.setOnClickListener{
                val position: Int = adapterPosition

                Toast.makeText(itemView.context, "You Clicked on ${titles[position]}", Toast.LENGTH_LONG).show()
            }
        }*/

    }


}
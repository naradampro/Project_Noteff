package com.teamnoteff.noteff.ui.recycler_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.CategoryCardBinding
import com.teamnoteff.noteff.entities.Note
import com.teamnoteff.noteff.entities.NoteCategory
import java.util.*

class ViewAllCategoriesRecyclerAdapter:RecyclerView.Adapter<ViewAllCategoriesRecyclerAdapter.ViewHolder>(){
    private lateinit var binding:CategoryCardBinding

    private val allCategoriesList = ArrayList<NoteCategory>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewAllCategoriesRecyclerAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.category_card, parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewAllCategoriesRecyclerAdapter.ViewHolder, position: Int) {
        holder.bind(allCategoriesList[position])
    }

    override fun getItemCount(): Int {
        return allCategoriesList.size
    }

    fun setList(category: List<NoteCategory>) {
        allCategoriesList.clear()
        allCategoriesList.addAll(category)
    }

    inner class ViewHolder(binding:CategoryCardBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(category: NoteCategory) {
            binding.txtDisplay.text = category.name
        }
        /*init {
            binding.cardView.setOnClickListener{
                val position: Int = adapterPosition

                Toast.makeText(itemView.context, "You Clicked on ${titles[position]}", Toast.LENGTH_LONG).show()
            }
        }*/

    }


}
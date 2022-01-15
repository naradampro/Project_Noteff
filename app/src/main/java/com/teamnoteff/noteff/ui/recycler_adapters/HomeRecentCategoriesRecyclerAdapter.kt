package com.teamnoteff.noteff.ui.recycler_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.RecentCategoryCardBinding
import com.teamnoteff.noteff.entities.NoteCategory
import java.util.*

class HomeRecentCategoriesRecyclerAdapter:RecyclerView.Adapter<HomeRecentCategoriesRecyclerAdapter.ViewHolder>(){
    private lateinit var binding: RecentCategoryCardBinding
    private val allCategoriesList = ArrayList<NoteCategory>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecentCategoriesRecyclerAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.recent_category_card, parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: HomeRecentCategoriesRecyclerAdapter.ViewHolder, position: Int) {
        holder.bind(allCategoriesList[position])
    }

    override fun getItemCount(): Int {
        return allCategoriesList.size
    }

    fun setList(category: List<NoteCategory>) {
        allCategoriesList.clear()
        allCategoriesList.addAll(category)
    }

    inner class ViewHolder(binding:RecentCategoryCardBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(category: NoteCategory) {
            binding.txtName.text = category.name
        }
        /*init {
            binding.cardView.setOnClickListener{
                val position: Int = adapterPosition

                Toast.makeText(itemView.context, "You Clicked on ${titles[position]}", Toast.LENGTH_LONG).show()
            }
        }*/

    }


}
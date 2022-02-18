package com.teamnoteff.noteff.ui.recycler_adapters

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.CategoryCardBinding
import com.teamnoteff.noteff.entities.Note
import com.teamnoteff.noteff.entities.NoteCategory
import java.util.*

class ViewAllCategoriesRecyclerAdapter(private val context: Context):RecyclerView.Adapter<ViewAllCategoriesRecyclerAdapter.ViewHolder>(){
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

    @SuppressLint("NotifyDataSetChanged")
    fun setList(category: List<NoteCategory>) {
        allCategoriesList.clear()
        allCategoriesList.addAll(category)
        notifyDataSetChanged()
    }

    inner class ViewHolder(binding:CategoryCardBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(category: NoteCategory) {
            binding.txtDisplay.text = category.name
        }

        init {
            binding.dropdown.setOnClickListener{
                popupMenus(it)
            }


            /*binding.cardView.setOnClickListener{
                val position: Int = adapterPosition

                Toast.makeText(itemView.context, "You Clicked on ${titles[position]}", Toast.LENGTH_LONG).show()
            }*/
        }

        private fun popupMenus(view: View){
            val position = allCategoriesList[adapterPosition]
            val popupMenu = PopupMenu(context, view)
            popupMenu.inflate(R.menu.category_card_menu)
            popupMenu.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.view ->
                        true
                    R.id.edit -> {
                        val v = LayoutInflater.from(context).inflate(R.layout.edit_category_fragment,null)
                        val categoryTitle: TextInputEditText = v.findViewById(R.id.title)

                        val builder = AlertDialog.Builder(context)
                        builder.setView(v)
                        //performing positive action
                        builder.setPositiveButton("Change") {dialog, which ->
                            //position.catTitle = category_title.text.toString()
                            notifyDataSetChanged()
                            Toast.makeText(context,"Category title is edited", Toast.LENGTH_LONG).show()
                            dialog.dismiss()
                        }

                        //performing negative action
                        builder.setNegativeButton("Cancel") {dialog, which ->
                            dialog.dismiss()
                        }

                        //create alert dialog
                        val altDialog: AlertDialog = builder.create()

                        altDialog.setCancelable(false)
                        altDialog.show()

                        true
                    }

                    R.id.remove -> showAlertDialog("Delete","Are you sure to remove this category")
                    else -> true
                }
            }

            popupMenu.show()
            val popup = PopupMenu::class.java.getDeclaredField("mPopup")
            popup.isAccessible = true
            popup.get(popupMenu).javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                .invoke(popup.get(popupMenu),true)

        }

        //category remove alert dialog box
        private fun showAlertDialog(title:String, message:String): Boolean {
            val builder = AlertDialog.Builder(context)
            //set title for alert dialog
            builder.setTitle(title)
            //set message for alert dialog
            builder.setMessage(message)

            //performing positive action
            builder.setPositiveButton("Yes") {dialog, which ->
                allCategoriesList.removeAt(adapterPosition)
                notifyDataSetChanged()
                Toast.makeText(context,"Category is deleted", Toast.LENGTH_LONG).show()
                dialog.dismiss()
            }

            //performing negative action
            builder.setNegativeButton("No") {dialog, which ->
                dialog.dismiss()
            }

            //create alert dialog
            val altDialog: AlertDialog = builder.create()

            altDialog.setCancelable(false)
            altDialog.show()

            return true
        }

    }
}


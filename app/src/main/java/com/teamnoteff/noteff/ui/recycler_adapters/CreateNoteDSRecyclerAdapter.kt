package com.teamnoteff.noteff.ui.recycler_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.teamnoteff.noteff.databinding.DsrvcardModifyImportantTextBinding
import com.teamnoteff.noteff.databinding.DsrvcardModifyPlainTextBinding
import com.teamnoteff.noteff.entities.*

class CreateNoteDSRecyclerAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var datasegments: ArrayList<DataSegment> = arrayListOf()

    companion object {
        const val PLAIN_TEXT_VIEW_TYPE = 1
        const val IMPORTANT_TEXT_VIEW_TYPE = 2
        const val PHONENUMBER_VIEW_TYPE = 3
        const val LINK_VIEW_TYPE = 4/*
        const val IMAGE_VIEW_TYPE = 5*/
    }

    override fun getItemViewType(position: Int): Int {
        if (datasegments[position] is PlainTextDataSegment) {
            return PLAIN_TEXT_VIEW_TYPE
        }
        else if (datasegments[position] is ImportantTextDataSegment) {
            return IMPORTANT_TEXT_VIEW_TYPE
        }
        else{
            return PLAIN_TEXT_VIEW_TYPE
        }
    }


    override fun getItemCount(): Int {
        return datasegments.size
    }

    fun setList(segments: List<DataSegment>) {
        this.datasegments.clear()
        this.datasegments.addAll(segments)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            /*Other types also comes like this.
            PHONENUMBER_VIEW_TYPE -> ImportantTextViewHolder(DsrvcardModifyPhoneNumberBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false))*/


            PLAIN_TEXT_VIEW_TYPE -> PlainTextViewHolder(DsrvcardModifyPlainTextBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false))

            PHONENUMBER_VIEW_TYPE -> PhoneNumberViewHolder(DsrvcardModifyPlainTextBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false))

            IMPORTANT_TEXT_VIEW_TYPE -> ImportantTextViewHolder(DsrvcardModifyImportantTextBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false))

            else -> PlainTextViewHolder(DsrvcardModifyPlainTextBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = datasegments[position]
        if (holder is PlainTextViewHolder && item is PlainTextDataSegment) {
            holder.bind(item)
        }
        else if (holder is ImportantTextViewHolder && item is ImportantTextDataSegment) {
            holder.bind(item)
        }
        else if (holder is PhoneNumberViewHolder && item is PhoneNumberDataSegment) {
            holder.bind(item)
        }
    }

    inner class PlainTextViewHolder(val binding: DsrvcardModifyPlainTextBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(segment: PlainTextDataSegment) {
            binding.txtPlainDisplay.text = segment.content
        }
    }

    inner class ImportantTextViewHolder(val binding: DsrvcardModifyImportantTextBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(segment: ImportantTextDataSegment) {
            binding.txtImportant.text = segment.content
        }
    }

    inner class PhoneNumberViewHolder(val binding: DsrvcardModifyPlainTextBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(segment: PhoneNumberDataSegment) {
            binding.txtPlainDisplay.text = segment.content
        }
    }

}
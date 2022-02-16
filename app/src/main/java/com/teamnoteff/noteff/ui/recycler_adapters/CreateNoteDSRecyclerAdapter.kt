package com.teamnoteff.noteff.ui.recycler_adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.*
import com.teamnoteff.noteff.entities.*
import com.teamnoteff.noteff.ui.create.CreateNoteViewModel


class CreateNoteDSRecyclerAdapter(
    private val mainViewModel: CreateNoteViewModel,
    val viewLifecycleOwner: LifecycleOwner,
    val parentFragment: Fragment?
):RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var datasegments: ArrayList<DataSegment> = arrayListOf()

    companion object {
        const val PLAIN_TEXT_VIEW_TYPE = 1
        const val IMPORTANT_TEXT_VIEW_TYPE = 2
        const val PHONENUMBER_VIEW_TYPE = 3
        const val LINK_VIEW_TYPE = 4
        const val IMAGE_VIEW_TYPE = 5
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            datasegments[position] is PlainTextDataSegment -> {
                PLAIN_TEXT_VIEW_TYPE
            }
            datasegments[position] is ImportantTextDataSegment -> {
                IMPORTANT_TEXT_VIEW_TYPE
            }
            datasegments[position] is PhoneNumberDataSegment -> {
                PHONENUMBER_VIEW_TYPE
            }
            datasegments[position] is LinkDataSegment -> {
                LINK_VIEW_TYPE
            }
            datasegments[position] is ImageDataSegment -> {
                IMAGE_VIEW_TYPE
            }
            else -> 0
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
            PLAIN_TEXT_VIEW_TYPE -> PlainTextViewHolder(DsrvcardModifyPlainTextBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false))

            IMPORTANT_TEXT_VIEW_TYPE -> ImportantTextViewHolder(DsrvcardModifyImportantTextBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false))

            //uses plain text card
            PHONENUMBER_VIEW_TYPE -> PhoneNumberViewHolder(DsrvcardModifyPhoneNumberBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false))

            //uses plain text card
            LINK_VIEW_TYPE -> LinkViewHolder(DsrvcardModifyLinkBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false))

            IMAGE_VIEW_TYPE -> ImageViewHolder(DsrvcardRemoveImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false))

            else -> PlainTextViewHolder(DsrvcardModifyPlainTextBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = datasegments[position]
        when {
            holder is PlainTextViewHolder && item is PlainTextDataSegment -> {
                holder.bind(item)
            }
            holder is ImportantTextViewHolder && item is ImportantTextDataSegment -> {
                holder.bind(item)
            }
            holder is PhoneNumberViewHolder && item is PhoneNumberDataSegment -> {
                holder.bind(item)
            }
            holder is LinkViewHolder && item is LinkDataSegment -> {
                holder.bind(item)
            }
            holder is ImageViewHolder && item is ImageDataSegment -> {
                holder.bind(item)
            }
        }
    }

    private fun deleteSegment(segment: DataSegment){
        mainViewModel.removeDataSegment(segment)
        mainViewModel.datasegments.observe(viewLifecycleOwner) {
            setList(it)
        }
    }

    inner class PlainTextViewHolder(val binding: DsrvcardModifyPlainTextBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(segment: PlainTextDataSegment) {
            binding.txtPlainDisplay.text = segment.content

            binding.btnDelete.setOnClickListener {
                deleteSegment(segment)
            }

            binding.btnEdit.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("content",segment.content)
                bundle.putInt("index", mainViewModel.datasegments.value?.indexOf(segment)!!)
                println(mainViewModel.datasegments.value?.indexOf(segment)!!)
                parentFragment!!.findNavController().navigate(R.id.action_createNoteFragment_to_plainTextFragment,bundle)
            }
        }
    }

    inner class ImportantTextViewHolder(val binding: DsrvcardModifyImportantTextBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(segment: ImportantTextDataSegment) {
            binding.txtImportant.text = segment.content

            binding.btnDelete.setOnClickListener {
                deleteSegment(segment)
            }
        }
    }

    inner class PhoneNumberViewHolder(val binding: DsrvcardModifyPhoneNumberBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(segment: PhoneNumberDataSegment) {
            binding.txtPhoneNumber.text = segment.content

            binding.btnDelete.setOnClickListener {
                deleteSegment(segment)
            }
        }
    }

    inner class LinkViewHolder(val binding: DsrvcardModifyLinkBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(segment: LinkDataSegment) {
            binding.txtLink.text = segment.content

            binding.btnDelete.setOnClickListener {
                deleteSegment(segment)
            }
        }
    }

    inner class ImageViewHolder(val binding: DsrvcardRemoveImageBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(segment: ImageDataSegment) {
            binding.imageview.setImageURI(segment.uri);

            binding.btnDelete.setOnClickListener {
                deleteSegment(segment)
            }
        }
    }

}
package com.teamnoteff.noteff.ui.updateview.dsupdate

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.teamnoteff.noteff.databinding.DsaddLinkFragmentBinding
import com.teamnoteff.noteff.entities.LinkDataSegment
import com.teamnoteff.noteff.ui.create.CreateNoteFragment
import com.teamnoteff.noteff.ui.updateview.UpdateViewViewModel

class LinkModifyFragment : DialogFragment() {

    companion object {
        fun newInstance() = LinkModifyFragment()
    }

    private val mainViewModel: UpdateViewViewModel by activityViewModels()
    private lateinit var binding: DsaddLinkFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DsaddLinkFragmentBinding.inflate(inflater, container, false)

        //the popup does not close when touched outside the popup
        isCancelable = false

        //Closing logic of popup
        binding.imgBtnClose.setOnClickListener{
            dismiss()
        }

        if(arguments==null){
            binding.btnAdd.setOnClickListener {
                addSegmentToRecyclerView()
            }
        }
        else{
            val index = arguments?.getInt("index")
            val content = arguments?.getString("content").toString()
            binding.etNoteTitle.setText(content)
            binding.btnAdd.text = "Update"
            binding.btnAdd.setOnClickListener {
                updateSegmentToRecyclerView(index!!)
            }
        }

        return binding.root
    }

    private fun addSegmentToRecyclerView(){
        val content = binding.etNoteTitle.text.toString()

        if(content.isEmpty()){
            binding.etNoteTitle.error="This field can not be empty"

        }
        else if(!Patterns.WEB_URL.matcher(content).matches()){
            binding.etNoteTitle.error="Enter valid URL"
        }
        else{
            //id and note id should be init later
            val segment = LinkDataSegment(content)

            mainViewModel.insertDataSegment(segment)

            //invoking the parent fragment's functions to update recycler view
            val ps = requireParentFragment().childFragmentManager?.fragments[0] as CreateNoteFragment
            ps.displayDataSegmentList()

            dismiss()
        }
    }

    private fun updateSegmentToRecyclerView(index:Int){
        val content = binding.etNoteTitle.text.toString()
        mainViewModel.updateDataSegment(index,content)
        //invoking the parent fragment's functions to update recycler view
        val ps = requireParentFragment().childFragmentManager?.fragments[0] as CreateNoteFragment
        ps.displayDataSegmentList()

        dismiss()
    }

}
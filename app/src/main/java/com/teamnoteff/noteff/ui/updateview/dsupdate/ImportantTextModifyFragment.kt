package com.teamnoteff.noteff.ui.updateview.dsupdate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.teamnoteff.noteff.databinding.DsaddImportantTextFragmentBinding
import com.teamnoteff.noteff.entities.ImportantTextDataSegment
import com.teamnoteff.noteff.ui.create.CreateNoteFragment
import com.teamnoteff.noteff.ui.updateview.ModifyOrRemoveFragment
import com.teamnoteff.noteff.ui.updateview.UpdateViewViewModel

class ImportantTextModifyFragment : DialogFragment() {

    companion object {
        fun newInstance() = ImportantTextModifyFragment()
    }

    private val mainViewModel: UpdateViewViewModel by activityViewModels()
    private lateinit var binding: DsaddImportantTextFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DsaddImportantTextFragmentBinding.inflate(inflater, container, false)

        //the popup does not close when touched outside the popup
        isCancelable = false

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
            binding.etNoteTitle.error="This field can not be empty"        }
        else{
            //id and note id should be init later
            val segment = ImportantTextDataSegment(content)

            mainViewModel.insertDataSegment(segment)

            //invoking the parent fragment's functions to update recycler view
            val ps = requireParentFragment().childFragmentManager?.fragments[0] as ModifyOrRemoveFragment
            ps.displayDataSegmentList()

            dismiss()
        }
    }

    private fun updateSegmentToRecyclerView(index:Int){
        val content = binding.etNoteTitle.text.toString()
        mainViewModel.updateDataSegment(index,content)
        //invoking the parent fragment's functions to update recycler view
        val ps = requireParentFragment().childFragmentManager?.fragments[0] as ModifyOrRemoveFragment
        ps.displayDataSegmentList()

        dismiss()
    }

}
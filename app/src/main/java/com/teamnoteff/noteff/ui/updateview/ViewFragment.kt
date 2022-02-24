package com.teamnoteff.noteff.ui.updateview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.ViewFragmentBinding
import com.teamnoteff.noteff.ui.recycler_adapters.ViewNoteDSRecyclerAdapter

class ViewFragment : Fragment() {

    companion object {
        fun newInstance() = ViewFragment()
    }

    private val mainViewModel: UpdateViewViewModel by activityViewModels()
    private lateinit var binding: ViewFragmentBinding
    private lateinit var dsAdapter: ViewNoteDSRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ViewFragmentBinding.inflate(layoutInflater)

        mainViewModel.getNoteById(mainViewModel.getNoteId()).observe(viewLifecycleOwner){note->
            binding.viewNoteTopPanel.apply {
                txtTitle.text = note[0].title
                txtDisplay.text = note[0].displaytext
                if(note[0].categoryId!=null){
                    mainViewModel.getCategoryById(note[0].categoryId!!).observe(viewLifecycleOwner){category->
                        txtCategory.text = category[0].name
                    }
                }
                else{
                    txtCategory.text = getString(R.string.txt_uncategorized)
                }
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dsAdapter = ViewNoteDSRecyclerAdapter(mainViewModel,viewLifecycleOwner,parentFragment)
        initDataSegmnetsList()
        println("Alert(Item count view DS adapter):"+dsAdapter.itemCount)
    }

    private fun initDataSegmnetsList(){
        binding.viewRecyclerview.apply {
            this.adapter = dsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        displayDataSegmentList()
    }

    fun displayDataSegmentList() {
        mainViewModel.datasegments.observe(viewLifecycleOwner) {
            dsAdapter.setList(it)
        }
    }
}
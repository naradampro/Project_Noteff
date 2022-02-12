package com.teamnoteff.noteff.ui.updateview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.teamnoteff.noteff.R
import com.teamnoteff.noteff.databinding.ActivityUpdateViewBinding

class UpdateViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_view)

            //Toggle group logics to select the  view or modify page
            binding.toggleButton.addOnButtonCheckedListener { _, checkedId, isChecked ->
                if (isChecked) {
                    when (checkedId) {
                        R.id.btnView ->  {
                            Navigation.findNavController(this,R.id.fcv_view_modify).navigate(R.id.action_modifyOrRemoveFragment_to_viewFragment)
                        }

                        R.id.btnModify -> {
                            Navigation.findNavController(this,R.id.fcv_view_modify).navigate(R.id.action_viewFragment_to_modifyOrRemoveFragment)
                        }
                    }
                }
            }
        }
}
package com.teamnoteff.noteff.ui.create

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.teamnoteff.noteff.R
import kotlinx.android.synthetic.main.activity_toggle.*

class ToggleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toggle)

        //attach the existing fragment
        supportFragmentManager.beginTransaction()
            .add(R.id.toggle_fragments_container,ExistingFragment())
            .commit()

        toggleButton.addOnButtonCheckedListener { toggleButton, checkedId, isChecked ->

            if(isChecked){
                when(checkedId){
                    R.id.btnExisting -> loadFragment(ExistingFragment())
                    R.id.btnNew -> loadFragment(NewFragment())
                    R.id.btnUncategorized -> loadFragment(UncategorizedFragment())
                }
            }
            else{
                if(toggleButton.checkedButtonId == View.NO_ID){

                    val displayToast = Toast.makeText(applicationContext,"Nothing Selected", Toast.LENGTH_SHORT)
                    displayToast.show()
                }
            }
        }
    }

    private fun loadFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.toggle_fragments_container,fragment)
            .commit()
    }
}
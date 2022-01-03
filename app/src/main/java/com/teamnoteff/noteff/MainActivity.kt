package com.teamnoteff.noteff

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.teamnoteff.noteff.databinding.ActivityMainBinding
import com.teamnoteff.noteff.ui.create.CreateNoteActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each

        navView.setupWithNavController(navController)

        val addNote = findViewById<FloatingActionButton>(R.id.floating_action_button)

//         addNote.setOnClickListener {
//            val i = Intent(this, CreateNoteActivity::class.java)
//            startActivity(i)
//        }
    }
}
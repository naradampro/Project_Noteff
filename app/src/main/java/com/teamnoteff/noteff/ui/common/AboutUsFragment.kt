package com.teamnoteff.noteff.ui.common

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.teamnoteff.noteff.R

class AboutUsFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Narada*/
        val imageButton1 = findViewById<ImageButton>(R.id.imageButton1)
        imageButton1.setOnClickListener({
            val url = "http://www.naradampro@gmail.com"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        })

        val imageButton2 = findViewById<ImageButton>(R.id.imageButton2)
        imageButton2.setOnClickListener({
            val url = "https://www.linkedin.com/in/naradaabeykoon"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        })

        val imageButton3 = findViewById<ImageButton>(R.id.imageButton3)
        imageButton3.setOnClickListener({
            val url = "https://www.github.com/naradampro"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        })

        /*Oshani*/
        val imageButton4 = findViewById<ImageButton>(R.id.imageButton4)
        imageButton4.setOnClickListener({
            val url = "http://oshani110@gmail.com"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        })

        val imageButton5 = findViewById<ImageButton>(R.id.imageButton5)
        imageButton5.setOnClickListener({
            val url = "https://www.linkedin.com/in/oshani-kaushalya-aa767a209"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        })

        val imageButton6 = findViewById<ImageButton>(R.id.imageButton6)
        imageButton6.setOnClickListener({
            val url = "http://www.github.com"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        })

        /*Dasuni*/
        val imageButton7 = findViewById<ImageButton>(R.id.imageButton7)
        imageButton7.setOnClickListener({
            val url = "http://www.dasunicharuka4.com"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        })

        val imageButton8 = findViewById<ImageButton>(R.id.imageButton8)
        imageButton8.setOnClickListener({
            val url = "https://www.linkedin.com/in/dasuni-charuka-4649911a7/"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        })

        val imageButton9 = findViewById<ImageButton>(R.id.imageButton9)
        imageButton9.setOnClickListener({
            val url = "https://github.com/whdcharuka"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        })

        /*Dilki*/
        val imageButton10 = findViewById<ImageButton>(R.id.imageButton10)
        imageButton10.setOnClickListener({
            val url = "http://www.dilkiayodhya2gmail.com"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        })

        val imageButton11 = findViewById<ImageButton>(R.id.imageButton11)
        imageButton11.setOnClickListener({
            val url = "https://www.linkedin.com/in/dilki-ayodhya-2068991a3/"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        })

        val imageButton12 = findViewById<ImageButton>(R.id.imageButton12)
        imageButton12.setOnClickListener({
            val url = "https://github.com/Ayodhya12"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        })

        /*Jayoda*/
        val imageButton13 = findViewById<ImageButton>(R.id.imageButton13)
        imageButton13.setOnClickListener({
            val url = "http://www.jayoda.shalloluwa@gmail.com"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        })

        val imageButton14 = findViewById<ImageButton>(R.id.imageButton14)
        imageButton14.setOnClickListener({
            val url = "https://www.linkedin.com/in/jayoda-halloluwa-9749591b2/"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        })

        val imageButton15 = findViewById<ImageButton>(R.id.imageButton15)
        imageButton15.setOnClickListener({
            val url = "http://www.github.com/jshalloluwa"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        })
    }
}
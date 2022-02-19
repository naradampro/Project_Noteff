package com.teamnoteff.noteff.ui.common

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil.setContentView
import com.teamnoteff.noteff.databinding.ActivityAboutUsBinding
import com.teamnoteff.noteff.databinding.ActivityHelpBinding

class AboutUsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutUsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutUsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "About Us"
        this.supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Developer Narada Abeykoon
        val devNarada = Developer(
            "Narada Abeykoon",
            "naradampro@gmail.com",
            "https://www.linkedin.com/in/naradaabeykoon",
            "https://www.github.com/naradampro")
        binding.imageButton1.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:"+devNarada.name)
            }
            startActivity(Intent.createChooser(emailIntent, "Send feedback"))
        }

        binding.imageButton2.setOnClickListener{
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(devNarada.linkedInProfile)
            startActivity(i)
        }

        binding.imageButton3.setOnClickListener{
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(devNarada.gitHubProfile)
            startActivity(i)
        }



        /*Oshani*/
        binding.imageButton4.setOnClickListener{
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:"+"oshani110@gmail.com")
            }
            startActivity(Intent.createChooser(emailIntent, "Send feedback"))
        }

        binding.imageButton5.setOnClickListener{
            val url = "https://www.linkedin.com/in/oshani-kaushalya-aa767a209"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        binding.imageButton6.setOnClickListener{
            val url = "http://www.github.com"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        /*Dasuni*/
        binding.imageButton7.setOnClickListener{
            val url = "http://www.dasunicharuka4.com"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        binding.imageButton8.setOnClickListener{
            val url = "https://www.linkedin.com/in/dasuni-charuka-4649911a7/"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        binding.imageButton9.setOnClickListener {
            val url = "https://github.com/whdcharuka"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        /*Dilki*/
        binding.imageButton10.setOnClickListener {
            val url = "http://www.dilkiayodhya2gmail.com"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        binding.imageButton11.setOnClickListener {
            val url = "https://www.linkedin.com/in/dilki-ayodhya-2068991a3/"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        binding.imageButton12.setOnClickListener {
            val url = "https://github.com/Ayodhya12"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        /*Jayoda*/
        binding.imageButton13.setOnClickListener {
            val url = "http://www.jayoda.shalloluwa@gmail.com"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        binding.imageButton14.setOnClickListener {
            val url = "https://www.linkedin.com/in/jayoda-halloluwa-9749591b2/"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        binding.imageButton15.setOnClickListener {
            val url = "http://www.github.com/jshalloluwa"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    data class Developer(
        val name:String,
        val email:String,
        val linkedInProfile:String,
        val gitHubProfile:String
    )

}

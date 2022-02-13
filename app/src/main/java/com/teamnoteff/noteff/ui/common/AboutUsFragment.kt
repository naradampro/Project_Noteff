package com.teamnoteff.noteff.ui.common

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.teamnoteff.noteff.databinding.AboutUsFragmentBinding
import com.teamnoteff.noteff.ui.create.CreateNoteFragment

class AboutUsFragment : Fragment() {
    companion object {
        fun newInstance() = CreateNoteFragment()
    }

    private lateinit var binding: AboutUsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= AboutUsFragmentBinding.inflate(inflater,container,false)

        /*Narada*/
        binding.imageButton1.setOnClickListener {
            val url = "http://www.naradampro@gmail.com"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        binding.imageButton2.setOnClickListener{
            val url = "https://www.linkedin.com/in/naradaabeykoon"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        binding.imageButton3.setOnClickListener{
            val url = "https://www.github.com/naradampro"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        /*Oshani*/
        binding.imageButton4.setOnClickListener{
            val url = "http://oshani110@gmail.com"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
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
        return binding.root
    }
}
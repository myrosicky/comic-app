package com.example.comic.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.comic.R
import com.example.comic.databinding.FragmentHomeBinding
import com.example.comic.service.LLRestTemplate

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var restTemplate : LLRestTemplate


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        restTemplate = new LLRestTemplate()
        restTemplate.post()
//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

        initImg(binding)




        return root
    }

    private fun initImg(binding: FragmentHomeBinding){
        val img : ImageView = binding.imageView
        img.setImageResource(R.drawable.paruru)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
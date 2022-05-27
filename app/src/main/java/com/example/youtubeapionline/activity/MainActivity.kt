package com.example.youtubeapionline.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapionline.R
import com.example.youtubeapionline.adapter.YoutubeAdapter
import com.example.youtubeapionline.databinding.ActivityMainBinding
import com.example.youtubeapionline.model.Item
import com.example.youtubeapionline.utils.Status
import com.example.youtubeapionline.viewmodel.YouTubeViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var youTubeViewModel: YouTubeViewModel
    private lateinit var youtubeAdapter: YoutubeAdapter
    private lateinit var list: ArrayList<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        youTubeViewModel = ViewModelProvider(this)[YouTubeViewModel::class.java]
        list = ArrayList()
        youtubeAdapter = YoutubeAdapter(list)
        binding.rv.adapter = youtubeAdapter
        initViews()
    }

    private fun initViews() {
        youTubeViewModel.getYouTubeData(this).observe(this, Observer {
            when (it.status){
                Status.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    it.data?.let { it1 -> list.addAll(it1.items) }
                    youtubeAdapter.notifyDataSetChanged()
                }
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        })

    }
}
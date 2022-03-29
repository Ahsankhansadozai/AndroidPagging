package com.example.androidpagging.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidpagging.databinding.ActivityMainBinding
import com.example.androidpagging.paging.QuotePagingAdapter
import com.example.androidpagging.viewmodels.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val quoteViewModel: QuoteViewModel by viewModels()
    private lateinit var adapter: QuotePagingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        adapter = QuotePagingAdapter()

        binding.quoteList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = adapter
        }

        quoteViewModel.list.observe(this) {
            adapter.submitData(lifecycle, it)
        }

    }
}
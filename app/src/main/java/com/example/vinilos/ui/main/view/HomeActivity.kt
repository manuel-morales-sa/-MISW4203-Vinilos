package com.example.vinilos.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vinilos.data.api.ApiHelper
import com.example.vinilos.data.api.RetrofitBuilder
import com.example.vinilos.data.model.albumResponse
import com.example.vinilos.ui.base.ViewModelFactory
import com.example.vinilos.ui.main.adapter.HomeAdapter
import com.example.vinilos.ui.main.viewmodel.HomeViewModel
import com.vinylsMobile.vinylsapplication.databinding.ActivityHomeBinding
import com.vinylsMobile.vinylsapplication.utils.Status

class HomeActivity : AppCompatActivity() {
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var adapter: HomeAdapter
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_home)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupUI()
        setupViewModel()
        setupObservers()
    }

    private fun setupUI() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = HomeAdapter(arrayListOf())
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerView.context,
                (binding.recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        binding.recyclerView.adapter = adapter
    }

    private fun setupObservers() {
        homeViewModel.getAlbums().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        binding.recyclerView.visibility = View.VISIBLE
                        binding.progressBar.visibility = View.GONE
                        resource.data?.let { albums -> retrieveList(albums) }
                    }
                    Status.ERROR-> {
                        binding.recyclerView.visibility = View.VISIBLE
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.recyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }


    private fun setupViewModel() {
        homeViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(HomeViewModel::class.java)
    }

    private fun retrieveList(albums: List<albumResponse>) {
        adapter.apply {
            addAlbums(albums)
            notifyDataSetChanged()
        }
    }
}
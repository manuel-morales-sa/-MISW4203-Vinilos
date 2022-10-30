package com.example.vinilos.ui.main.view

import android.R
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.vinilos.data.api.ApiHelper
import com.example.vinilos.data.api.RetrofitBuilder
import com.example.vinilos.data.model.albumResponse
import com.vinylsMobile.vinylsapplication.databinding.ActivityDetailAlbumBinding
import com.example.vinilos.ui.base.ViewModelFactory
import com.example.vinilos.ui.main.adapter.DetailAdapter
import com.example.vinilos.ui.main.adapter.ID
import com.example.vinilos.ui.main.viewmodel.MainViewModel
import com.vinylsMobile.vinylsapplication.utils.Status

class DetailAlbumActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: DetailAdapter

    private lateinit var binding: ActivityDetailAlbumBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailAlbumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        val id = intent.getStringExtra(ID)!!

        setupViewModel()
        setupObservers(id)
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)
    }

    private fun setupObservers(id:String) {
        mainViewModel.getAlbumDetail(id).observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let { albumDetail -> retrieveAlbumDetail(albumDetail) }
                    }
                    Status.ERROR -> {
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
    }

    private fun retrieveAlbumDetail(album: albumResponse) {
        adapter = DetailAdapter(album)
        adapter.adaptData(binding)
        supportActionBar?.title =album.name
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                finish()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }


}
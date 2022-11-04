package com.example.vinilos.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.vinilos.data.api.ApiHelper
import com.example.vinilos.data.repository.albumRepository
import com.example.vinilos.ui.main.viewmodel.HomeViewModel

class ViewModelFactory (private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(albumRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Clase desconocida")
    }

    }
package com.example.vinilos.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.vinilos.data.repository.albumRepository
import com.vinylsMobile.vinylsapplication.utils.Resource


import kotlinx.coroutines.Dispatchers

class MainViewModel(private val albumRepository: albumRepository): ViewModel() {
    fun getAlbums() = liveData(Dispatchers.IO) {
    emit(Resource.loading(data = null))
    try {
        emit(Resource.success(data = albumRepository.getAlbums()))
    } catch (exception: Exception) {
        emit(Resource.error(data = null, msg = exception.message ?: "Un error ha ocurrido!"))
    }
}

    fun getAlbumDetail(id: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = albumRepository.getAlbumDetail(id)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, msg = exception.message ?: "Un error ha ocurrido!"))
        }
    }
}
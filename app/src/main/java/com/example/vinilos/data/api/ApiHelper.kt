package com.example.vinilos.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getAlbums() = apiService.getAlbums()
    suspend fun getAlbumDetail(id:String) = apiService.getAlbumDetail(id)

}
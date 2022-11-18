package com.example.vinilos.data.repository

import com.example.vinilos.data.api.RetrofitBuilder
import com.example.vinilos.data.model.Album
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class AlbumService {
    private val retrofit = RetrofitBuilder.getRetrofit()

    suspend fun getAlbums():List<Album> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(AlbumApiClient::class.java).getAllAlbums()
            response.body() ?: emptyList()
        }
    }

    suspend fun createAlbum(album : HashMap<String,String>): Response<Album> {
        return retrofit.create(AlbumApiClient::class.java).createAlbum(album)
    }
}
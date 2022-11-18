package com.example.vinilos.data.repository

import com.example.vinilos.data.api.RetrofitHelper
import com.example.vinilos.data.model.ArtistResponse
import com.example.vinilos.data.model.CollectorResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ArtistService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getArtist():List<ArtistResponse> {
        return   withContext(Dispatchers.IO) {
            val response = retrofit.create(ArtistApiClient::class.java).getAllArtist()
            response.body() ?: emptyList()
        }
    }


}
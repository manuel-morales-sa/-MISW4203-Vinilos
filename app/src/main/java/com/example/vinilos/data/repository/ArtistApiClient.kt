package com.example.vinilos.data.repository

import com.example.vinilos.data.model.ArtistResponse
import retrofit2.Response
import retrofit2.http.GET

interface ArtistApiClient {
    @GET("artist")
    suspend fun getAllArtist(): Response<List<ArtistResponse>>
}
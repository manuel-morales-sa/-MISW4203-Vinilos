package com.example.vinilos.data.api


import com.example.vinilos.data.model.albumResponse

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
        @GET("albums")
        suspend fun getAlbums(): List<albumResponse>

        @GET("albums/{id}")
        suspend fun getAlbumDetail(@Path("id") id: String): albumResponse
}
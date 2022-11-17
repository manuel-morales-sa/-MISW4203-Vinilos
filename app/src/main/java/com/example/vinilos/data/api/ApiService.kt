package com.example.vinilos.data.api


import com.example.vinilos.data.model.AlbumResponse
import com.example.vinilos.data.model.ArtistResponse
import com.example.vinilos.data.model.CollectorResponse

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
        @GET("albums")
        suspend fun getAlbums(): List<AlbumResponse>

        @GET("albums/{id}")
        suspend fun getAlbumDetail(@Path("id") id: String): AlbumResponse

        @GET("musicians")
        suspend fun getMusicians(): List<ArtistResponse>

        @GET("bands")
        suspend fun getBands(): List<ArtistResponse>

        @GET("collectors")
        suspend fun getCollectors(): List<CollectorResponse>

        @GET("musicians/{id}")
        suspend fun getMusiciansDetail(@Path("id") id: String): ArtistResponse

        @GET("bands/{id}")
        suspend fun getBandsDetail(@Path("id") id: String): ArtistResponse

        @GET("collectors/{id}")
        suspend fun getCollectorsDetail(@Path("id") id: String): CollectorResponse
}
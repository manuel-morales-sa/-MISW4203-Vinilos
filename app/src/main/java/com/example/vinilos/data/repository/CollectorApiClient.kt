package com.example.vinilos.data.repository

import com.example.vinilos.data.model.CollectorResponse
import retrofit2.Response
import retrofit2.http.GET

interface CollectorApiClient {
    @GET("collectors")
    suspend fun getAllCollectors(): Response<List<CollectorResponse>>
}
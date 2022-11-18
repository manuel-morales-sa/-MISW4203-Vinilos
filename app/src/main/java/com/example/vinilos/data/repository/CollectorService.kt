package com.example.vinilos.data.repository

import com.example.vinilos.data.api.RetrofitHelper
import com.example.vinilos.data.model.CollectorResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CollectorService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getCollectors():List<CollectorResponse> {
        return   withContext(Dispatchers.IO) {
            val response = retrofit.create(CollectorApiClient::class.java).getAllCollectors()
            response.body() ?: emptyList()
        }
    }


}
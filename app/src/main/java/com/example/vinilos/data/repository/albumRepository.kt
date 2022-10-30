package com.example.vinilos.data.repository

import com.example.vinilos.data.api.ApiHelper

class albumRepository(private val apiHelper: ApiHelper) {

     suspend fun getAlbums() = apiHelper.getAlbums()

     suspend fun getAlbumDetail(id:String) = apiHelper.getAlbumDetail(id)
}
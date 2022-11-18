package com.example.vinilos.ui.main.viewmodel

import android.content.Context
import com.example.vinilos.data.model.Comments

class CacheManager(context: Context) {
    companion object{
        var instance: CacheManager? = null
        fun getInstance(context: Context) =
            instance ?: synchronized(this) {
                instance ?: CacheManager(context).also {
                    instance = it
                }
            }
    }
    private var comments: HashMap<Int, List<Comments>> = hashMapOf()
    fun addComments(albumId: Int, comment: List<Comments>){
        if (!comments.containsKey(albumId)){
            comments[albumId] = comment
        }
    }
    fun getComments(albumId: Int) : List<Comments>{
        return if (comments.containsKey(albumId)) comments[albumId]!! else listOf<Comments>()
    }
}
package com.example.vinilos.ui.main.adapter


import com.bumptech.glide.Glide

import com.example.vinilos.data.model.albumResponse
import com.vinylsMobile.vinylsapplication.databinding.ActivityDetailAlbumBinding

class DetailAdapter (private val albumDetail: albumResponse)  {

    fun adaptData(binding: ActivityDetailAlbumBinding) {
        Glide.with(binding.imageViewAlbumDetails.context)
            .load(albumDetail.cover)
            .into(binding.imageViewAlbumDetails)
        binding.textViewArtist.text=albumDetail.releaseDate.toString()
        binding.textViewGenre.text=albumDetail.genre
        binding.textViewRecord.text=albumDetail.recordLabel
        binding.textViewDescrption.text=albumDetail.description
    }
}
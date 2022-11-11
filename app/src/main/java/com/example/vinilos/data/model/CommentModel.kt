package com.vinylsMobile.vinylsApplication.data.model

import com.google.gson.annotations.SerializedName

class CommentModel {
    @SerializedName("id")
    lateinit var id: Number

    @SerializedName("description")
    var name: String? = null

    @SerializedName("rating")
    lateinit var rating: Number
}
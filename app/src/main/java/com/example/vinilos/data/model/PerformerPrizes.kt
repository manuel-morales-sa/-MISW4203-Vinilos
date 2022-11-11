package com.vinylsMobile.vinylsApplication.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

class PerformerPrizes {
    @SerializedName("id")
    lateinit var id: Number

    @SerializedName("premiationDate")
    var premiationDate: Date? = null
}
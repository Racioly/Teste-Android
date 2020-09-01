package br.com.teste.mobileandroid.model

import com.google.gson.annotations.SerializedName

open class BaseModel(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("bannerURL")
    val bannerURL: String? = null,
    @SerializedName("description")
    val description: String? = null
)
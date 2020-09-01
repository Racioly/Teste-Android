package br.com.teste.mobileandroid.model

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("imageURL")
    val imageURL: String? = null
): BaseModel()
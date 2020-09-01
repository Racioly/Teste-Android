package br.com.teste.mobileandroid.model

import com.google.gson.annotations.SerializedName

data class Cash (
    @SerializedName("title")
    val title: String? = null
): BaseModel()
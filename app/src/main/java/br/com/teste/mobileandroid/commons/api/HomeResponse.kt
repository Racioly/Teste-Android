package br.com.teste.mobileandroid.commons.api

import br.com.teste.mobileandroid.model.BaseModel
import br.com.teste.mobileandroid.model.Cash
import br.com.teste.mobileandroid.model.Product
import com.google.gson.annotations.SerializedName

data class HomeResponse (
    @SerializedName("spotlight")
    val spotlight: List<BaseModel>? = null,
    @SerializedName("products")
    val products: List<Product>? = null,
    @SerializedName("cash")
    val cash: Cash? = null
)
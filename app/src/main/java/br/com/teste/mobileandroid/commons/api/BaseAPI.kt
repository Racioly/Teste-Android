package br.com.teste.mobileandroid.commons.api

import io.reactivex.Observable
import retrofit2.http.GET

interface BaseAPI {

    @GET("products")
    fun getHome(): Observable<HomeResponse>
}
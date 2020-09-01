package br.com.teste.mobileandroid.commons.api

import io.reactivex.Observable

class HomeRepository(baseRestClient: BaseRestClient) {

    private val api = baseRestClient

    fun getHome(): Observable<HomeResponse>{
        return api.api.getHome()
    }
}
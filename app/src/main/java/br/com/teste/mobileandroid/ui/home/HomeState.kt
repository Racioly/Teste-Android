package br.com.teste.mobileandroid.ui.home

import br.com.teste.mobileandroid.commons.api.HomeResponse

sealed class HomeState {

    object Loading: HomeState()

    data class HomeResponseSuccess(val homeResponse: HomeResponse): HomeState()

    data class HomeResponseFailure(val message: String): HomeState()
}
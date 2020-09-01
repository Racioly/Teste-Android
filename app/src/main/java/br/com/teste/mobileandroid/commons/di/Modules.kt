package br.com.teste.mobileandroid.commons.di

import br.com.teste.mobileandroid.commons.api.BaseRestClient
import br.com.teste.mobileandroid.commons.api.HomeRepository
import br.com.teste.mobileandroid.ui.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module(override = true) {
    single { BaseRestClient() }
    single { HomeRepository(get()) }
    viewModel { HomeViewModel(get()) }
}
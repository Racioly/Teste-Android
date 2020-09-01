package br.com.teste.mobileandroid

import android.app.Application
import br.com.teste.mobileandroid.commons.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        //Setup koin
        startKoin {
            androidContext(this@MyApplication)
            modules(homeModule)
        }
    }
}
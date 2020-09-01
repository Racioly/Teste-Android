package br.com.teste.mobileandroid.ui.home

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.teste.mobileandroid.commons.api.HomeRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

open class HomeViewModel(private val repository: HomeRepository): ViewModel(), LifecycleObserver {

    private val state = MutableLiveData<HomeState>()

    fun getState(): MutableLiveData<HomeState> = state

    fun getHome(){

        state.value = HomeState.Loading

        var disposible = repository.getHome()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {homeResponse ->
                    homeResponse?.let {
                        state.value = HomeState.HomeResponseSuccess(it)
                    }
                },
                {error ->
                    error?.let {throwable ->
                        state.value = throwable.message?.let { errorMessage ->
                            HomeState.HomeResponseFailure(message = errorMessage)
                        }
                    }
                }
            )
    }
}
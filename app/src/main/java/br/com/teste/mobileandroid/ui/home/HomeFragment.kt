package br.com.teste.mobileandroid.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.teste.mobileandroid.R
import br.com.teste.mobileandroid.commons.api.HomeResponse
import br.com.teste.mobileandroid.ui.BaseFragment
import br.com.teste.mobileandroid.ui.home.adapters.HomeAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class HomeFragment : BaseFragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by sharedViewModel()
    private lateinit var TAG: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        TAG = getString(R.string.text_home_fragment)

        configToolbar()

        viewModel.getHome()

        viewModel.getState().observe(viewLifecycleOwner, Observer { state ->
            handleState(state)
        })
    }

    private fun handleState(state: HomeState) {
        Log.d(TAG, "State: $state")
        handleLoading(state)
        when(state){
            is HomeState.HomeResponseSuccess -> { handleSuccess(state.homeResponse) }
            is HomeState.HomeResponseFailure -> { handleFailure(state.message)      }
        }
    }

    private fun handleLoading(state: HomeState) {
        if (state == HomeState.Loading){
            mProgress?.show()
        }else{
            mProgress?.dismiss()
        }
    }

    private fun handleSuccess(homeResponse: HomeResponse) {
        activity?.let {
            rcv_home.apply {
                layoutManager = LinearLayoutManager(
                    it,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                setHasFixedSize(true)
                adapter = HomeAdapter(homeResponse = homeResponse)
            }
        }

    }
}
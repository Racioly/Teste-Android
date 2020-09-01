package br.com.teste.mobileandroid.ui

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import br.com.teste.mobileandroid.R
import kotlinx.android.synthetic.main.appbar_default.*

open class BaseFragment(@LayoutRes fragment: Int): Fragment(fragment) {

    var mProgress: Dialog? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val builder =
            AlertDialog.Builder(activity, R.style.MyDialogTheme)
        val alert: View =
            LayoutInflater.from(activity).inflate(R.layout.progress_layout, null)
        builder.setCancelable(false)
            .setView(alert)
        (mProgress as AlertDialog?)?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        mProgress = builder.create()
        super.onViewCreated(view, savedInstanceState)
    }

    protected open fun configToolbar(){
        activity?.let {
            toolbar.apply {
                logo = ContextCompat.getDrawable(it,R.drawable.ic_logo)
                title = it.getString(R.string.text_welcome)
                titleMarginStart = 100
                setTitleTextColor(ContextCompat.getColor(it, R.color.colorPrimaryDark))
            }
        }
    }

    protected open fun handleFailure(errorMessage: String) {
        activity?.let {
            AlertDialog.Builder(it)
                .setTitle(getString(R.string.text_attention))
                .setMessage(errorMessage)
                .setPositiveButton(getString(R.string.text_ok), null)
                .create()
                .show()
        }
    }

}
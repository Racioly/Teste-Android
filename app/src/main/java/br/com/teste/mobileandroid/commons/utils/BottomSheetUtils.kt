package br.com.teste.mobileandroid.commons.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import br.com.teste.mobileandroid.R
import com.google.android.material.bottomsheet.BottomSheetDialog

object BottomSheetUtils{

    var dialog: BottomSheetDialog? = null

    fun showBottomSheetCustom(
        context: Context,
        title: String?,
        description: String?,
        positiveButtonText: String?,
        positiveListener: View.OnClickListener
    ){
        val viewCustom = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_custom, null)
        viewCustom.findViewById<TextView>(R.id.txv_sheet_title).text = title
        viewCustom.findViewById<TextView>(R.id.txv_sheet_descripition).text = description
        val btnPositive = viewCustom.findViewById<Button>(R.id.btn_sheet_positive)
        btnPositive.text = positiveButtonText
        btnPositive.setOnClickListener (positiveListener)
        dialog = BottomSheetDialog(context, R.style.SheetDialog)
        dialog?.setContentView(viewCustom)
        dialog?.create()
        dialog?.show()
    }
}
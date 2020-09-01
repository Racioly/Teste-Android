package br.com.teste.mobileandroid.ui.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import br.com.teste.mobileandroid.R
import br.com.teste.mobileandroid.commons.utils.BottomSheetUtils
import br.com.teste.mobileandroid.model.BaseModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class SpotlightAdapter(private val mList: List<BaseModel>): RecyclerView.Adapter<SpotlightAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(R.layout.row_items_spotlight, parent, false))

    override fun getItemCount(): Int = mList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(mList[position].bannerURL)
            .apply(RequestOptions().centerInside())
            .into(holder.imvSpotlight)

        holder.imvSpotlight.setOnClickListener {
            BottomSheetUtils.showBottomSheetCustom(
                context = holder.itemView.context,
                title = mList[position].name,
                description = mList[position].description,
                positiveButtonText = holder.itemView.context.getString(R.string.text_back),
                positiveListener = View.OnClickListener { BottomSheetUtils.dialog?.dismiss() }
            )
        }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imvSpotlight: ImageView = itemView.findViewById(R.id.imv_spotlight)
    }
}
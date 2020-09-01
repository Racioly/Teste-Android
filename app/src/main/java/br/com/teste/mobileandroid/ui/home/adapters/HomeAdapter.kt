package br.com.teste.mobileandroid.ui.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.teste.mobileandroid.R
import br.com.teste.mobileandroid.commons.api.HomeResponse
import br.com.teste.mobileandroid.commons.utils.BottomSheetUtils
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class HomeAdapter(private val homeResponse: HomeResponse): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int = position

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var viewHolder: RecyclerView.ViewHolder? = null
        when(viewType){
            0 -> {
               viewHolder = ViewHolderSpotlight(LayoutInflater
                   .from(parent.context)
                   .inflate(R.layout.row_spotlight, parent, false))
            }
            1 -> {
                viewHolder = ViewHolderCash(LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.row_cash, parent, false))
            }
            2 -> {
                viewHolder = ViewHolderProducts(LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.row_products, parent, false))
            }
        }

        return viewHolder!!
    }

    override fun getItemCount(): Int = 3

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(position){
            0 -> {
                holder as ViewHolderSpotlight
                holder.rcvSpotlight.apply {
                    layoutManager = LinearLayoutManager(
                        holder.itemView.context,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )
                    setHasFixedSize(true)
                    adapter = homeResponse.spotlight?.let { SpotlightAdapter(it) }
                }
            }
            1 -> {
                holder as ViewHolderCash
                Glide.with(holder.itemView)
                    .load(homeResponse.cash?.bannerURL)
                    .apply(RequestOptions().centerInside())

                    .into(holder.imvCash)

                holder.imvCash.setOnClickListener {
                    BottomSheetUtils.showBottomSheetCustom(
                        context = holder.itemView.context,
                        title = homeResponse.cash?.title,
                        description = homeResponse.cash?.description,
                        positiveButtonText = holder.itemView.context.getString(R.string.text_back),
                        positiveListener = View.OnClickListener { BottomSheetUtils.dialog?.dismiss() }
                    )
                }
            }
            2 -> {
                holder as ViewHolderProducts
                holder.rcvProducts.apply {
                    layoutManager = LinearLayoutManager(
                        holder.itemView.context,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )
                    setHasFixedSize(true)
                    adapter = homeResponse.products?.let { ProductsAdapter(it) }
                }
            }
        }
    }

    class ViewHolderSpotlight(itemView: View): RecyclerView.ViewHolder(itemView) {
        val rcvSpotlight: RecyclerView = itemView.findViewById(R.id.rcv_spotlight)
    }

    class ViewHolderProducts(itemView: View): RecyclerView.ViewHolder(itemView) {
        val rcvProducts: RecyclerView = itemView.findViewById(R.id.rcv_products)
    }

    class ViewHolderCash(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imvCash: ImageView = itemView.findViewById(R.id.imv_cash)
    }

}
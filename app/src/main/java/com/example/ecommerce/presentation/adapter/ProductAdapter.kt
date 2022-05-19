package com.example.ecommerce.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.ecommerce.R
import com.example.ecommerce.data.Product


class ProductAdapter(val context : Context) :
    PagingDataAdapter<Product, ProductAdapter.RedditViewHolder>(DiffUtilCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RedditViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_row, parent, false)
        return RedditViewHolder(view)
    }

    override fun onBindViewHolder(holder: RedditViewHolder, position: Int) {
        getItem(position)?.let { redditPost ->
            holder.bindPost(redditPost,context)
        }

    }

    class RedditViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val text: TextView = itemView.findViewById(R.id.tv)
        private val imageView: ImageView = itemView.findViewById(R.id.iv)
        private val ratingTv: TextView = itemView.findViewById(R.id.rating)


        fun bindPost(product: Product,context: Context) {
            with(product) {
                text.text = product.title
                ratingTv.text = product.rating.rate.toString()
                Glide.with(context)
                    .load(product.image)
                    .diskCacheStrategy(DiskCacheStrategy.DATA)

                    .into(imageView)

            }
        }
    }
}
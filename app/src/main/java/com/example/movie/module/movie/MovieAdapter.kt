package com.example.movie.module.movie

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.movie.R
import com.example.movie.base.list.BaseAdapter
import com.example.movie.base.list.BaseViewHolder
import com.example.movie.model.Items
import com.example.movie.model.Movie
import com.example.movie.model.ServerData

class MovieAdapter(context: Context) :
    BaseAdapter<Items, MovieAdapter.ItemsViewHolder>(context) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieAdapter.ItemsViewHolder {
        val viewHolder = ItemsViewHolder(
            LayoutInflater.from(context).inflate(R.layout.items_movie, parent, false)
        )
        return viewHolder

    }

    override fun onBindViewHolder(holder: MovieAdapter.ItemsViewHolder, position: Int) {
        holder.bindData(data[position], position)
        holder.itemView.setOnClickListener{
                val intent = Intent(context, MovieActivity::class.java)
                intent.putExtra("Slug", data[position].slug)
                intent.putExtra("nameMovie", data[position].name)
                intent.putExtra("year", data[position].year)
               context.startActivity(intent)
        }
    }

    inner class ItemsViewHolder(itemView: View) : BaseViewHolder<Items>(itemView) {
        private val imageView = itemView.findViewById<ImageView>(R.id.imvThumnail) // Thêm ImageView

        override fun bindData(item: Items, position: Int) {
            Glide.with(itemView.context)
                .load(item.posterUrl)
                .placeholder(R.drawable.loading_image)

                .error(R.drawable.img)
                .into(imageView)  // Load vào ImageView
        }
    }

    fun updateMovies(newMovies: ArrayList<Items>) {
          // Xóa danh sách cũ
        data.addAll(newMovies)
        notifyDataSetChanged()  // Cập nhật giao diện
    }


}
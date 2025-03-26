package com.example.movie.module.movie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.movie.R
import com.example.movie.base.list.BaseAdapter
import com.example.movie.base.list.BaseViewHolder
import com.example.movie.model.Items
import com.example.movie.model.Movie
import com.example.movie.model.ServerData

class MovieAdapter(context: Context):
        BaseAdapter<ServerData, MovieAdapter.ItemsViewHolder>(context){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieAdapter.ItemsViewHolder {
        val viewHolder =ItemsViewHolder(
            LayoutInflater.from(context).inflate(R.layout.items_movie, parent, false)
        )
        return viewHolder

    }

    override fun onBindViewHolder(holder: MovieAdapter.ItemsViewHolder, position: Int) {
        holder.bindData(data[position], position)
    }
    inner  class ItemsViewHolder(itemView: View) : BaseViewHolder<ServerData>(itemView) {
        override fun bindData(item: ServerData, position: Int) {
            itemView.findViewById<TextView>(R.id.titleMovie).text= item.name
        }
    }
    fun updateMovies(newMovies: Movie) {
        data.clear()  // Xóa danh sách cũ
        notifyDataSetChanged()  // Cập nhật giao diện
    }



}
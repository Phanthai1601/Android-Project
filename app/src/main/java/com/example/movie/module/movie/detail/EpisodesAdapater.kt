package com.example.movie.module.movie.detail


import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

import com.example.movie.R
import com.example.movie.base.list.BaseAdapter
import com.example.movie.base.list.BaseViewHolder
import com.example.movie.model.ServerData

import com.example.movie.model.response.MovieDetailResponse

class EpisodesAdapater(
    context: Context,
) :
    BaseAdapter<ServerData, EpisodesAdapater.ItemsViewHolder>(context) {
    private var movieName: String = ""
    private var imageUrl: String = ""
    private var selectedPosition: Int = 0


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemsViewHolder {
        val viewHolder = ItemsViewHolder(
            LayoutInflater.from(context).inflate(R.layout.items_episodes, parent, false)
        )
        return viewHolder

    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.bindData(data[position], position)
    }

    inner class ItemsViewHolder(itemView: View) : BaseViewHolder<ServerData>(itemView) {
        var episode: TextView
        var nameMovie: TextView
        var imgThumbnail: ImageView

        init {
            episode = itemView.findViewById(R.id.tvEpisodeName)
            nameMovie = itemView.findViewById(R.id.tvMovieName)
            imgThumbnail = itemView.findViewById(R.id.imgThumbnail)
        }

        override fun bindData(item: ServerData, position: Int) {
            episode.text = item.name
            nameMovie.text = movieName
            Glide.with(itemView.context)
                .load(imageUrl)
                .placeholder(R.drawable.loading_image)
                .error(R.drawable.img)
                .into(imgThumbnail)
            if (position == selectedPosition) {
                itemView.setBackgroundResource(R.drawable.bg_selected_item)
            } else {
                itemView.setBackgroundResource(android.R.color.transparent)
            }
            itemView.setOnClickListener {
                val previousPosition = selectedPosition
                selectedPosition = position
                notifyItemChanged(previousPosition)
                notifyItemChanged(selectedPosition)
            }

        }
    }

    fun submitList(movieDetail: MovieDetailResponse) {
        movieName = movieDetail.movie.name.toString()
        imageUrl = movieDetail.movie.thumbUrl.toString()
        val episodesList = movieDetail.episodes.firstOrNull()?.serverData ?: emptyList()
        Log.d("EpisodesAdapter", "submitList size: ${episodesList.size}")
        data.clear()
        data.addAll(episodesList)
        notifyDataSetChanged()
    }


}
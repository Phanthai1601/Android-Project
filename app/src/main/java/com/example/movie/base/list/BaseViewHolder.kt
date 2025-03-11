package com.example.movie.base.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import java.text.FieldPosition

abstract class BaseViewHolder<DataType>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bindData(item: DataType, position: Int)
}
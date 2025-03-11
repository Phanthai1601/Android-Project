package com.example.movie.base.list

import android.content.Context
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<DataType, ViewHolderType : BaseViewHolder<DataType>>(open val context: Context) :
    RecyclerView.Adapter<ViewHolderType>() {
    var data: MutableList<DataType> = mutableListOf()
    var onItemClick: ((item: DataType, position: Int) -> Unit)? = null

    override fun getItemCount(): Int {
        return data.size
    }

    open fun refreshList(items: MutableList<DataType>?) {
        data.clear()
        if (items != null) {
            data.addAll(items)
        }
        notifyDataSetChanged()
    }

    fun addItem(item: DataType) {
        data.add(item)
        notifyItemInserted(data.size.minus(1))
    }

    fun addItem(item: DataType, position: Int) {
        data.add(position, item)
        notifyItemInserted(position)
    }

    fun removeItem(position: Int) {
        data.removeAt(position)
        notifyItemRemoved(position)
    }

    fun getItem(position: Int): DataType = data[position]
}
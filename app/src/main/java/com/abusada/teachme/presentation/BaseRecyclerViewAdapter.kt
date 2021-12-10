package com.abusada.teachme.presentation

import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<T> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var mItems = ArrayList<T>()

    override fun getItemCount(): Int {
        return mItems.size
    }

}
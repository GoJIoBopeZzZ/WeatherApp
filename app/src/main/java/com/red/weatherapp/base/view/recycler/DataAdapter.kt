package com.red.weatherapp.base.view.recycler

import android.support.v7.widget.RecyclerView

abstract class DataAdapter<T, VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {

    protected val data = mutableListOf<T>()

    fun setData(data: List<T>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = data.size

}
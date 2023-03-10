package com.mindorks.example.paging3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pagingv3simple.Data.Model.Data
import com.example.pagingv3simple.R

import kotlinx.android.synthetic.main.list_item.view.*

class MainListAdapter : PagingDataAdapter<Data, MainListAdapter.ViewHolder>(DataDifferntiator) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.textViewName.text =
            "${getItem(position)?.first_name} ${getItem(position)?.last_name}"
        holder.itemView.textViewEmail.text = getItem(position)?.email
        Glide.with(holder.itemView.context).load(getItem(position)?.avatar)
            .placeholder(R.drawable.ic_launcher_foreground).into(holder.itemView.imageView)
//        holder.itemView

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.list_item, parent, false)
        )
    }

    object DataDifferntiator : DiffUtil.ItemCallback<Data>() {

        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }

}

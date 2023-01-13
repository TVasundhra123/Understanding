package com.example.understanding.adapters

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.understanding.R
import com.example.understanding.network.ItemResponse
import com.example.understanding.network.Items

class ItemsAdapter(private val data: MutableList<Items>) : RecyclerView.Adapter<ItemsViewHolder>() {

    // OnCreateViewHolder gets called only  equal to no. of views that are visible on the screen
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ItemsViewHolder(view)
    }

    // onBindViewHolder gets called equal to no. of items present in the data set cause it binds the data to the view
    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        val dataToBeSent = data[position]
        holder.bind(dataToBeSent)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(item: List<Items>?) {
        data.clear()
        if (item != null) data.addAll(item)
        notifyDataSetChanged()
    }
}

class ItemsViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val title: TextView = itemView.findViewById(R.id.title_movie)
    private val image: ImageView = itemView.findViewById(R.id.movie_poster)

    fun bind(data: Items) {
        title.text = data.Title
        Glide.with(itemView.context).load(data.Poster).into(image)
    }
}
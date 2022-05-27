package com.example.youtubeapionline.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapionline.databinding.ItemYoutubeBinding
import com.example.youtubeapionline.model.Item
import com.squareup.picasso.Picasso

class YoutubeAdapter(val list: List<Item>) :
    RecyclerView.Adapter<YoutubeAdapter.Vh>() {

    inner class Vh(var itemYoutubeBinding: ItemYoutubeBinding) :
        RecyclerView.ViewHolder(itemYoutubeBinding.root) {

        fun onBind(item: Item) {
            itemYoutubeBinding.apply {
                Picasso.get().load(item.snippet.thumbnails.high.url).into(image)
                tvTitle.text = item.snippet.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemYoutubeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}
package com.example.demorecyclerview.stickyheader

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demorecyclerview.databinding.StickyItemBinding
import com.example.demorecyclerview.getLayoutInflater

class ItemViewHolder(val binding : StickyItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun build(data: StickyData){
        binding.tvItem.text = data.title
    }

    companion object{
        fun create(parent: ViewGroup): ItemViewHolder {
            return ItemViewHolder(StickyItemBinding.inflate(parent.getLayoutInflater(), parent, false))
        }
    }

}

package com.example.demorecyclerview.stickyheader

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demorecyclerview.databinding.HeaderItemBinding
import com.example.demorecyclerview.getLayoutInflater

class HeaderViewHolder(val binding : HeaderItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun build(data: StickyData){
        binding.tvHeader.text = data.title
    }

    companion object{
        fun create(parent: ViewGroup): HeaderViewHolder {
            return HeaderViewHolder(HeaderItemBinding.inflate(parent.getLayoutInflater(), parent, false))
        }
    }

}

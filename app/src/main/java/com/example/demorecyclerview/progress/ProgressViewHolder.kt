package com.example.demorecyclerview.progress

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demorecyclerview.databinding.HeaderItemBinding
import com.example.demorecyclerview.databinding.ItemProgressBinding
import com.example.demorecyclerview.getLayoutInflater

class ProgressViewHolder(val binding : ItemProgressBinding) : RecyclerView.ViewHolder(binding.root) {

    fun build(data: ProgressData){
        binding.title.text = data.title
        updateProgress(data.progress)
    }

    fun updateProgress(progress:Int){
        binding.progress.text = "$progress"
    }

    companion object{
        fun create(parent: ViewGroup): ProgressViewHolder {
            return ProgressViewHolder(ItemProgressBinding.inflate(parent.getLayoutInflater(), parent, false))
        }
    }

}

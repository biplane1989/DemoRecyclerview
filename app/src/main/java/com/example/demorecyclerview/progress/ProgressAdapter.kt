package com.example.demorecyclerview.progress

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

const val UPDATE_PROGRESS = 1

class ProgressAdapter : ListAdapter<ProgressData, ProgressViewHolder>(DiffProgressUnit()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgressViewHolder {
        return ProgressViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ProgressViewHolder, position: Int) {
        holder.build(getItem(position))
    }

    override fun onBindViewHolder(holder: ProgressViewHolder, position: Int, payloads: MutableList<Any>) {
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position)
        } else {
            val state = payloads.firstOrNull() as Int
            if (state == UPDATE_PROGRESS) {
                holder.updateProgress(getItem(position).progress)
            }
        }
    }

    override fun submitList(list: List<ProgressData>?) {
        super.submitList(ArrayList<ProgressData>(list ?: listOf()))
    }

}

class DiffProgressUnit : DiffUtil.ItemCallback<ProgressData>() {
    override fun areItemsTheSame(oldItem: ProgressData, newItem: ProgressData): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: ProgressData, newItem: ProgressData): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: ProgressData, newItem: ProgressData): Any? {
        if (oldItem.progress != newItem.progress) {
            return UPDATE_PROGRESS
        }
        return null
    }

}

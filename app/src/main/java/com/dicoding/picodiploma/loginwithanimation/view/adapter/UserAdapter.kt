package com.dicoding.picodiploma.loginwithanimation.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.picodiploma.loginwithanimation.data.response.ListStoryItem
import com.dicoding.picodiploma.loginwithanimation.databinding.LayoutItemBinding

class UserAdapter(private val itemsClicked: (ListStoryItem) -> Unit) : PagingDataAdapter<ListStoryItem, UserAdapter.MyViewHolder>(
    DIFF_CALLBACK
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.MyViewHolder {
        val binding = LayoutItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }
    override fun onBindViewHolder(holder: UserAdapter.MyViewHolder, position: Int) {
        val user = getItem(position)
        if (user != null) {
            holder.bind(user)
        }
    }
    inner class MyViewHolder(val binding: LayoutItemBinding) : RecyclerView.ViewHolder(
        binding.root) {

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val user = getItem(position)
                    if (user != null) {
                        itemsClicked(user)
                    }
                }
            }
        }

        @SuppressLint("SetTextI18n")
        fun bind(listStoryItem: ListStoryItem) {
            binding.tvName.text = listStoryItem.name
            binding.tvDesc.text = listStoryItem.description
            Glide.with(binding.root.context)
                .load(listStoryItem.photoUrl)
                .into(binding.tvImage)

            itemView.setOnClickListener {
                itemsClicked(listStoryItem)
            }
        }

    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ListStoryItem>() {
            override fun areItemsTheSame(oldItem: ListStoryItem, newItem: ListStoryItem): Boolean {
                return oldItem == newItem
            }
            override fun areContentsTheSame(oldItem: ListStoryItem, newItem: ListStoryItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}
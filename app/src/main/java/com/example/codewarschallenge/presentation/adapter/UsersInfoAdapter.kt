package com.example.codewarschallenge.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codewarschallenge.databinding.ItemSearchedUsersBinding
import com.example.codewarschallenge.domain.model.User

class UsersInfoAdapter(val users: List<User>): RecyclerView.Adapter<UsersInfoAdapter.UsersInfoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersInfoViewHolder {
        val binding = ItemSearchedUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UsersInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsersInfoViewHolder, position: Int) {
        holder.bindViews()
    }

    override fun getItemCount() = users.size

    inner class UsersInfoViewHolder(private val binding: ItemSearchedUsersBinding): RecyclerView.ViewHolder(binding.root) {

        fun bindViews() {
            val user = users[absoluteAdapterPosition]
            binding.tvSearchedUsersName.text = user.name
            binding.tvSearchedUsersRank.text = user.leaderboardPosition.toString()
        }
    }
}
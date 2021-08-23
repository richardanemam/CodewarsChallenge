package com.example.codewarschallenge.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codewarschallenge.databinding.ItemSearchedUsersBinding
import com.example.codewarschallenge.domain.listener.ShowChallengesListener
import com.example.codewarschallenge.domain.model.UserInfoModel

class UsersInfoAdapter(private val listener: ShowChallengesListener): RecyclerView.Adapter<UsersInfoAdapter.UsersInfoViewHolder>() {

    private val users = mutableListOf<UserInfoModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersInfoViewHolder {
        val binding = ItemSearchedUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UsersInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsersInfoViewHolder, position: Int) {
        holder.bindViews()
    }

    override fun getItemCount() = users.size

    fun updateUsers(orderedUsers: List<UserInfoModel>) {
        users.clear()
        users.addAll(orderedUsers)
        notifyDataSetChanged()
    }

    inner class UsersInfoViewHolder(private val binding: ItemSearchedUsersBinding): RecyclerView.ViewHolder(binding.root) {

        fun bindViews() {
            val user = users[absoluteAdapterPosition]
            binding.tvSearchedUsersName.text = user.name
            binding.tvSearchedUsersRank.text = user.leaderBoardPosition.toString()
            binding.tvSearchedUsersBestLanguage.text = user.bestLanguage
            binding.tvSearchedUsersLanguageScore.text = user.bestLanguageScore.toString()
            onClickShowChallenges(user.userName)
        }

        private fun onClickShowChallenges(username: String) {
            binding.btnSearchedUsersShowChallenges.setOnClickListener {
                listener.onClickShowChallenges(username)
            }
        }
    }
}
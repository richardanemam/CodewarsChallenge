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
            user.name?.let { binding.tvSearchedUsersName.text = it }
            user.leaderBoardPosition?.let { binding.tvSearchedUsersRank.text = it.toString() }
            user.bestLanguage?.let { binding.tvSearchedUsersBestLanguage.text = it }
            user.bestLanguageScore?.let { binding.tvSearchedUsersLanguageScore.text = it.toString() }
            onClickShowChallenges(user.userName)
        }

        private fun onClickShowChallenges(username: String) {
            binding.btnSearchedUsersShowChallenges.setOnClickListener {
                listener.onClickShowChallenges(username)
            }
        }
    }
}
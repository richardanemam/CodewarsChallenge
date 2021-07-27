package com.example.codewarschallenge.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codewarschallenge.databinding.ItemSearchedUsersBinding
import com.example.codewarschallenge.domain.helper.LanguagesMapHelper
import com.example.codewarschallenge.domain.listener.ShowChallengesListener
import com.example.codewarschallenge.domain.model.UserModel

class UsersInfoAdapter(private val listener: ShowChallengesListener): RecyclerView.Adapter<UsersInfoAdapter.UsersInfoViewHolder>() {

    private val users = mutableListOf<UserModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersInfoViewHolder {
        val binding = ItemSearchedUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UsersInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsersInfoViewHolder, position: Int) {
        holder.bindViews()
    }

    override fun getItemCount() = users.size

    fun updateUsers(orderedUsers: List<UserModel>) {
        users.clear()
        users.addAll(orderedUsers)
        notifyDataSetChanged()
    }

    inner class UsersInfoViewHolder(private val binding: ItemSearchedUsersBinding): RecyclerView.ViewHolder(binding.root) {

        fun bindViews() {
            val user = users[absoluteAdapterPosition]
            binding.tvSearchedUsersName.text = user.name
            binding.tvSearchedUsersRank.text = user.leaderboardPosition.toString()
            binding.tvSearchedUsersBestLanguage.text = user.ranks?.languages?.let {
                LanguagesMapHelper.getBestLanguage(
                    it
                )?.languageName
            }
            binding.tvSearchedUsersLanguageScore.text = user.ranks?.languages?.let {
                LanguagesMapHelper.getBestLanguage(
                    it
                )?.score.toString()
            }
            onClickShowChallenges(user)
        }

        private fun onClickShowChallenges(user: UserModel) {
            binding.btnSearchedUsersShowChallenges.setOnClickListener {
                user.userName?.let { username -> listener.onClickShowChallenges(username) }
            }
        }
    }
}
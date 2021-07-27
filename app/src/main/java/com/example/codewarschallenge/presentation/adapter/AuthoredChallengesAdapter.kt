package com.example.codewarschallenge.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codewarschallenge.databinding.ItemChallengesBinding
import com.example.codewarschallenge.domain.listener.ChallengeDetailsListener
import com.example.codewarschallenge.domain.model.AuthoredChallengesData

class AuthoredChallengesAdapter(
    private val data: List<AuthoredChallengesData>,
    private val listener: ChallengeDetailsListener
) : RecyclerView.Adapter<AuthoredChallengesAdapter.AuthoredChallengesViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AuthoredChallengesViewHolder {
        val binding =
            ItemChallengesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AuthoredChallengesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AuthoredChallengesViewHolder, position: Int) {
        holder.bindViews()
    }

    override fun getItemCount() = data.size

    inner class AuthoredChallengesViewHolder(private val binding: ItemChallengesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindViews() {
            binding.tvItemChallengesName.text = data[absoluteAdapterPosition].name
            binding.tvItemChallengesDesciption.text = data[absoluteAdapterPosition].description
            onClickViewDetails()
        }

        private fun onClickViewDetails() {
            binding.btnItemChallengesViewChallengeDetails.setOnClickListener {
                listener.onClickViewAuthoredChallengeDetails(data[absoluteAdapterPosition])
            }
        }
    }
}
package com.example.codewarschallenge.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codewarschallenge.R
import com.example.codewarschallenge.databinding.ItemChallengesBinding
import com.example.codewarschallenge.domain.listener.ChallengeDetailsListener
import com.example.codewarschallenge.domain.model.CompleteChallengesData

class CompleteChallengesAdapter(
    private val data: List<CompleteChallengesData>,
    private val listener: ChallengeDetailsListener
): RecyclerView.Adapter<CompleteChallengesAdapter.CompleteChallengesViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CompleteChallengesViewHolder {
        val binding = ItemChallengesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CompleteChallengesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CompleteChallengesViewHolder, position: Int) {
       holder.bindViews()
    }

    override fun getItemCount() = data.size

    inner class CompleteChallengesViewHolder(private val binding: ItemChallengesBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindViews() {
            binding.tvItemChallengesName.text = data[absoluteAdapterPosition].name
            binding.tvItemChallengesDesciption.text = data[absoluteAdapterPosition].completedAt
            binding.tvItemChallengesDescriptionTitle.text =
                binding.tvItemChallengesDescriptionTitle
                    .context
                    .getString(R.string.challenges_item_completed_at)
            onClickViewDetails()
        }

        private fun onClickViewDetails() {
            binding.btnItemChallengesViewChallengeDetails.setOnClickListener {
                listener.onClickViewCompleteChallengeDetails(data[absoluteAdapterPosition])
            }
        }
    }
}
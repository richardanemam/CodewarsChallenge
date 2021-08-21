package com.example.codewarschallenge.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codewarschallenge.databinding.FragmentCompleteChallengesBinding
import com.example.codewarschallenge.domain.listener.ChallengeDetailsListener
import com.example.codewarschallenge.domain.model.CompleteChallengesData
import com.example.codewarschallenge.presentation.adapter.CompleteChallengesAdapter

class CompleteChallengesFragment: Fragment() {

    private lateinit var listener: ChallengeDetailsListener
    private lateinit var challengesData: List<CompleteChallengesData>
    private lateinit var binding: FragmentCompleteChallengesBinding

    companion object {
        private const val EXTRA_COMPLETE_CHALLENGES = "completeChallenges"
        fun newInstance(data: List<CompleteChallengesData>) = CompleteChallengesFragment().apply {
            arguments = bundleOf(EXTRA_COMPLETE_CHALLENGES to data)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCompleteChallengesBinding.inflate(inflater, container, false)
        setUpExtras()
        setUpViews()
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as ChallengeDetailsListener
        }catch (e: ClassCastException) {
            throw ClassCastException(e.message)
        }
    }

    private fun setUpExtras() {
        challengesData = arguments?.getParcelableArrayList<CompleteChallengesData>(
            EXTRA_COMPLETE_CHALLENGES
        ) as List<CompleteChallengesData>
    }

    private fun  setUpViews() {
        binding.rvCompleteChallengesList.adapter = CompleteChallengesAdapter(challengesData, listener)
        binding.rvCompleteChallengesList.layoutManager = LinearLayoutManager(binding.root.context)
    }
}
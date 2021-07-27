package com.example.codewarschallenge.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.codewarschallenge.R
import com.example.codewarschallenge.domain.model.CompleteChallengesData
import com.example.codewarschallenge.presentation.adapter.CompleteChallengesAdapter

class CompleteChallengesFragment: Fragment() {

    private lateinit var rvChallenges: RecyclerView
    private lateinit var challengesData: List<CompleteChallengesData>

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
    ): View? {
        val view = inflater.inflate(R.layout.fragment_complete_challenges, container, false)
        setUpExtras()
        setUpViews(view)
        return view
    }

    private fun setUpExtras() {
        challengesData = arguments?.getParcelableArrayList<CompleteChallengesData>(
            EXTRA_COMPLETE_CHALLENGES
        ) as List<CompleteChallengesData>
    }

    private fun  setUpViews(view: View) {
        rvChallenges = view.findViewById(R.id.rv_complete_challenges_list)
        rvChallenges.adapter = CompleteChallengesAdapter(challengesData)
        rvChallenges.layoutManager = LinearLayoutManager(view.context)
    }
}
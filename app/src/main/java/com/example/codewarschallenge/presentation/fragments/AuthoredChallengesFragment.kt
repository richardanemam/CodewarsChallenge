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
import com.example.codewarschallenge.domain.model.AuthoredChallengesData
import com.example.codewarschallenge.presentation.adapter.AuthoredChallengesAdapter

class AuthoredChallengesFragment: Fragment() {

    private lateinit var rvChallenges: RecyclerView
    private lateinit var challengesData: List<AuthoredChallengesData>

    companion object {
        private const val EXTRA_AUTHORED_CHALLENGES = "authoredChallenges"
        fun newInstance(data: List<AuthoredChallengesData>) = AuthoredChallengesFragment().apply {
            arguments = bundleOf(EXTRA_AUTHORED_CHALLENGES to data)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_authored_challenges, container, false)
        setUpExtras()
        setUpViews(view)
        return view
    }

    private fun setUpExtras() {
        challengesData = arguments?.getParcelableArrayList<AuthoredChallengesData>(
            EXTRA_AUTHORED_CHALLENGES
        ) as List<AuthoredChallengesData>
    }

    private fun  setUpViews(view: View) {
        rvChallenges = view.findViewById(R.id.rv_authored_challenges_list)
        rvChallenges.adapter = AuthoredChallengesAdapter(challengesData)
        rvChallenges.layoutManager = LinearLayoutManager(view.context)
    }
}
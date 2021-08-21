package com.example.codewarschallenge.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codewarschallenge.databinding.FragmentAuthoredChallengesBinding
import com.example.codewarschallenge.domain.listener.ChallengeDetailsListener
import com.example.codewarschallenge.domain.model.AuthoredChallengesData
import com.example.codewarschallenge.presentation.adapter.AuthoredChallengesAdapter
import java.lang.ClassCastException

class AuthoredChallengesFragment: Fragment() {

    private lateinit var challengesData: List<AuthoredChallengesData>
    private lateinit var listener: ChallengeDetailsListener
    private lateinit var binding: FragmentAuthoredChallengesBinding

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
    ): View {
        binding = FragmentAuthoredChallengesBinding.inflate(inflater, container, false)
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
        challengesData = arguments?.getParcelableArrayList<AuthoredChallengesData>(
            EXTRA_AUTHORED_CHALLENGES
        ) as List<AuthoredChallengesData>
    }

    private fun  setUpViews() {
        binding.rvAuthoredChallengesList.adapter = AuthoredChallengesAdapter(challengesData, listener)
        binding.rvAuthoredChallengesList.layoutManager = LinearLayoutManager(binding.root.context)
    }
}